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
 * @author Libardo, Julio
 */
public class ServerSocketRestaurant extends ServerSocketTemplate {

    /**
     * Servicio de clientes
     */
    private FoodService service;

    /**
     * Constructor
     */
    public ServerSocketRestaurant() {
    }
    
     /**
     * Inicialización
     * @return este mismo objeto
     */
    @Override
    protected ServerSocketTemplate init(){
        PORT = Integer.parseInt(Utilities.loadProperty("server.port"));
         // Se hace la inyección de dependencia
        IFoodRepository repository = RepositoryFactory.getInstance().getRepository("default"); 
        this.setService(new FoodService(repository));
        return this;
    }
    
    /**
     * Procesar la solicitud que proviene de la aplicación cliente
     *
     * @param requestJson petición que proviene del cliente socket en formato
     * json que viene de esta manera:
     * "{"resource":"customer","action":"get","parameters":[{"name":"id","value":"1"}]}"
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
                    // Consultar un comida
                    processGetFood(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un comida    
                    processPostFood(protocolRequest);

                }
                if (protocolRequest.getAction().equals("delete")) {
                    // eliminar un comida    
                    processDeleteFood(protocolRequest);

                }
                
                if (protocolRequest.getAction().equals("update")) {
                    // actualizar una comida     
                    processUpdateFood(protocolRequest);

                }
                if (protocolRequest.getAction().equals("findall")) {
                    // listar las comidas   
                    processgetAllFood(protocolRequest);
                    
                }
                break;
        }

    }

    /**
     * Procesa la solicitud de consultar un customer
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetFood(Protocol protocolRequest) {
        // Extraer la cedula del primer parámetro
        String id = protocolRequest.getParameters().get(0).getValue();
        Food customer = getService().findByIdl(Integer.parseInt(id));
        if (customer == null) {
            String errorJson = generateNotFoundErrorJson("no se encontró la comida");
            respond(errorJson);
        } else {
            respond(objectToJSON(customer));
        }
    }

    private void processPostFood(Protocol protocolRequest) {
        Food food = new Food();
        // Reconstruir el objeto Food a partir de lo que viene en los parámetros
        food.setId(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        food.setName(protocolRequest.getParameters().get(1).getValue());
        food.setType(FoodTypeEnum.valueOf(protocolRequest.getParameters().get(2).getValue()));
        
        String response = getService().create(food);
        respond(response);
    }

    private void processUpdateFood(Protocol protocolRequest) {
        Food food = new Food();
        // Reconstruir el objeto Food a partir de lo que viene en los parámetros
        food.setId(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        food.setName(protocolRequest.getParameters().get(1).getValue());
        food.setType(FoodTypeEnum.valueOf(protocolRequest.getParameters().get(2).getValue()));
        
        String response = getService().update(food);
        respond(response);
    }
    private void processDeleteFood(Protocol protocolRequest) {
        int id = Integer.parseInt(protocolRequest.getParameters().get(0).getValue()); 
        service.delete(id);
    }

    private void processgetAllFood(Protocol protocolRequest) {
        List<Food> disp = service.findAll();
        if (disp == null) {
            String errorJson = generateNotFoundErrorJson("Sin coincidencias.");
            respond(errorJson);
        } else {
            if (disp.isEmpty()) {
                respond(new Gson().toJson("Info: Sin coincidencias"));
            } else {
                respond(Utilities.listToJson(disp));
            }
        }
    }
    
    /**
     * Genera un ErrorJson de cliente no encontrado
     *
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
        String errorsJson = gson.toJson(errors);

        return errorsJson;
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

    
   
}
