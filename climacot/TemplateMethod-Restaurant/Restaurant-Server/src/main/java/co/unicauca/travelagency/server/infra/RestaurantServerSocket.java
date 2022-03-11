package co.unicauca.travelagency.server.infra;

import co.unicauca.serversocket.serversockettemplate.infra.ServerSocketTemplate;
import co.unicauca.travelagency.commons.domain.Food;
import co.unicauca.travelagency.commons.domain.FoodTypeEnum;
import co.unicauca.travelagency.commons.infra.JsonError;
import co.unicauca.travelagency.commons.infra.Protocol;
import co.unicauca.travelagency.commons.infra.Utilities;
import co.unicauca.travelagency.server.access.Factory;
import co.unicauca.travelagency.server.domain.services.FoodService;
import co.unicauca.travelagency.server.access.IFoodRepository;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 * Servidor Socket que está escuchando permanentemente solicitudes de los
 * clientes. Cada solicitud la atiende en un hilo de ejecución
 *
 * @author Libardo, Julio
 */
public class RestaurantServerSocket extends ServerSocketTemplate {

    private FoodService service;

    /**
     * Constructor
     */
    public RestaurantServerSocket() {
    }

    @Override
    protected ServerSocketTemplate init() {
        PORT = Integer.parseInt(Utilities.loadProperty("server.port"));
        // Se hace la inyección de dependencia
        IFoodRepository repository = Factory.getInstance().getRepository();
        this.setService(new FoodService(repository));
        return this;
    }

    /**
     * Procesar la solicitud que proviene de la aplicación cliente
     *
     * @param requestJson petición que proviene del cliente socket en formato
     *                    json.
     *
     */
    @Override
    protected void processRequest(String requestJson) {
        // Convertir la solicitud a objeto Protocol para poderlo procesar
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);

        switch (protocolRequest.getResource()) {
            case "food":
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un Food
                    processGetFood(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un Food
                    processPostFood(protocolRequest);

                }
                break;
        }

    }

    /**
     * Procesa la solicitud de agregar una Food
     * 
     * @param protocolRequest Protocolo de la solicitud
     */
    protected void processPostFood(Protocol protocolRequest) {
        Food food = new Food();
        // Reconstruir el Food a partir de lo que viene en los parámetros
        food.setId(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        food.setName(protocolRequest.getParameters().get(1).getValue());
        food.setType(FoodTypeEnum.valueOf(protocolRequest.getParameters().get(2).getValue()));
        String response = getService().create(food);
        respond(response);
    }

    /**
     * Procesa la solicitud de consultar una comida
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetFood(Protocol protocolRequest) {
        // Extraer el id del primer parámetro
        String id = protocolRequest.getParameters().get(0).getValue();
        Food food = getService().findByIdl(Integer.parseInt(id));
        if (food == null) {
            String errorJson = generateNotFoundErrorJson();
            respond(errorJson);
        } else {
            respond(objectToJSON(food));
        }
    }

    /**
     * @return the service
     */
    public FoodService getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(FoodService service) {
        this.service = service;
    }

    /**
     * Genera un ErrorJson de Food no encontrado
     *
     * @return error en formato json
     */
    private String generateNotFoundErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("404");
        error.setError("NOT_FOUND");
        error.setMessage("Comida no encontrado. id no existe");
        errors.add(error);

        Gson gson = new Gson();
        String errorsJson = gson.toJson(errors);

        return errorsJson;
    }

}