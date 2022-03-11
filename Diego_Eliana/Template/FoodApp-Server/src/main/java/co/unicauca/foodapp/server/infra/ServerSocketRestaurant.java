package co.unicauca.foodapp.server.infra;
import co.unicauca.serversocket.serversockettemplate.infra.ServerSocketTemplate;

import co.unicauca.foodapp.commons.infra.JsonError;
import co.unicauca.foodapp.commons.infra.Protocol;
import co.unicauca.foodapp.commons.infra.Utilities;
import co.unicauca.foodapp.server.access.IFoodRepository;
import co.unicauca.foodapp.server.access.RepositoryFactory;
import co.unicauca.foodapp.server.domain.services.FoodService;
import co.unicauca.foodapp.commons.domain.Food;
import co.unicauca.foodapp.commons.domain.FoodTypeEnum;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 * Servidor Socket que está escuchando permanentemente solicitudes de los
 * clientes. Cada solicitud la atiende en un hilo de ejecución
 *
 * @author Diego Collazos, Eliana Cerquera
 */
public class ServerSocketRestaurant extends ServerSocketTemplate {

    /**
     * Instancia del servicio de comidas
     */
    private FoodService service;

    /**
     * Constructor por defecto
     */
    public ServerSocketRestaurant() {}
    
    @Override
    protected ServerSocketTemplate init(){
        PORT = Integer.parseInt(Utilities.loadProperty("server.port"));
        IFoodRepository repository = RepositoryFactory.getInstance().getRepository("default"); 
        this.setService(new FoodService(repository));
        return this;
    }
    
    @Override
    protected void processRequest(String requestJson) {
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);

        switch (protocolRequest.getResource()) {
            case "food":
                if (protocolRequest.getAction().equals("get")) {
                    processGetFood(protocolRequest);
                }
                if (protocolRequest.getAction().equals("post")) {
                    processPostFood(protocolRequest);
                }
                if (protocolRequest.getAction().equals("delete")) {
                    processDeleteFood(protocolRequest);
                }
                if (protocolRequest.getAction().equals("update")) {
                    processUpdateFood(protocolRequest);
                }
                if (protocolRequest.getAction().equals("findall")) {
                    processgetAllFood(protocolRequest);
                }
                break;
        }
    }
    
    /**
     * Procesa la solicitud de consultar una comida por su id
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetFood(Protocol protocolRequest) {
        String id = protocolRequest.getParameters().get(0).getValue();
        Food food = getService().findById(Integer.parseInt(id));
        if (food == null) {
            String errorJson = generateNotFoundErrorJson("no se encontró la comida");
            respond(errorJson);
        } else {
            respond(objectToJSON(food));
        }
    }

    /**
     * Procesa la solicitud de crear una comida
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processPostFood(Protocol protocolRequest) {
        Food food = new Food(
            Integer.parseInt(protocolRequest.getParameters().get(0).getValue()),
            protocolRequest.getParameters().get(1).getValue(),
            FoodTypeEnum.valueOf(protocolRequest.getParameters().get(2).getValue()));
        String response = getService().create(food);
        respond(response);
    }

    /**
     * Procesa la solicitud de modificar una comida
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processUpdateFood(Protocol protocolRequest) {
        Food food = new Food(
            Integer.parseInt(protocolRequest.getParameters().get(0).getValue()),
            protocolRequest.getParameters().get(1).getValue(),
            FoodTypeEnum.valueOf(protocolRequest.getParameters().get(2).getValue()));
        String response = getService().update(food);
        respond(response);
    }
    
    /**
     * Procesa la solicitud de eliminar una comida por su id
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processDeleteFood(Protocol protocolRequest) {
        int id = Integer.parseInt(protocolRequest.getParameters().get(0).getValue()); 
        service.delete(id);
    }

    /**
     * Procesa la solicitud de listar las comidas disponibles
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processgetAllFood(Protocol protocolRequest) {
        List<Food> disp = service.findAll();
        if (disp == null) {
            String errorJson = generateNotFoundErrorJson("Sin coincidencias.");
            respond(errorJson);
            return;
        }
        if (disp.isEmpty()) {
            respond(new Gson().toJson("Info: Sin coincidencias"));
            return;
        }
        respond(Utilities.listToJson(disp));
    }
    
    /**
     * Genera un ErrorJson de comida no encontrada
     * @return error en formato json
     */
    private String generateNotFoundErrorJson(String msg) {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("404");
        error.setError("NOT_FOUND");
        error.setMessage(msg);
        errors.add(error);

        Gson gson = new Gson();
        return gson.toJson(errors);
    }

    /**
     * Getter del servicio
     * @return service
     */
    public FoodService getService() {
        return service;
    }

    /**
     * Setter del servicio
     * @param service nuevo
     */
    public void setService(FoodService service) {
        this.service = service;
    }
}
