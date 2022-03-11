package co.unicauca.restaurant.server.infra;

import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.commons.domain.FoodTypeEnum;
import co.unicauca.restaurant.commons.infra.JsonError;
import co.unicauca.restaurant.commons.infra.Protocol;
import co.unicauca.restaurant.server.access.Factory;
import co.unicauca.restaurant.server.access.IFoodRepository;
import co.unicauca.restaurant.server.domain.services.FoodService;
import co.unicauca.serversocket.serversockettemplate.helpers.Utilities;
import co.unicauca.serversocket.serversockettemplate.infra.ServerSocketTemplate;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Creación y manejo del socket para el server del restaurante
 * @author XssIsor
 */
public class RestaurantServerSocket extends ServerSocketTemplate{
    
    /**
     * Servicios dedicados a las comidas
     */
     private FoodService service;

    /**
     * Constructor
     */
    public RestaurantServerSocket() {
    }
    
    /**
     * Procesa una solicitud para agregar una nueva comida de acuerdo a los parámetros del protocolo de entrada.
     * @param protocolR  Protocol. Protocolo de solicitud.
     * @throws java.lang.Exception
     */
    protected void processAddFood(Protocol protocolR) throws Exception {
        Food food = new Food();
        if(Utilities.isNumeric(protocolR.getParameters().get(0).getValue())){
            food.setId( Integer.parseInt(protocolR.getParameters().get(0).getValue()) );
        }else{
            throw new Exception("El id debe ser numético");
        }
        food.setName(protocolR.getParameters().get(1).getValue());
        food.setType(FoodTypeEnum.valueOf(protocolR.getParameters().get(2).getValue()));
        String response = getService().create(food);
        respond(response);
    }

    /**
     * Procesa una solicitud de búsqueda de comida por ID de acuerdo al protocolo de entrada
     * @param protocolR Protocol. Protocolo de solicitud.
     */
    private void processGetFood(Protocol protocolR) throws Exception {
        String id = "";
        if(Utilities.isNumeric(protocolR.getParameters().get(0).getValue())){
            id = protocolR.getParameters().get(0).getValue();
        }else{
            throw new Exception("El id debe ser numético");
        }
        Food food = getService().findByIdl(Integer.parseInt(id));
        if (food == null) {
            String errorJson = generateNotFoundErrorJson();
            respond(errorJson);
        } else {
            respond(objectToJSON(food));
        }
    }
    
     /**
     * Setter del servicio de comida.
     * @param service FoodService. Servicio a asignar.
     */
    public void setService(FoodService service) {
        this.service = service;
    }

    /**
     * Getter del servicio de comida.
     * @return service FoodService. Servicio de comida.
     */
    public FoodService getService() {
        return service;
    }

    /**
     * Genera un error de Json para cuando no lo encuentra.
     * @return errorsJson String. un error en formato de Json.
     */
    private String generateNotFoundErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        
        error.setCode("404");
        error.setError("NOT_FOUND");
        error.setMessage("La comida no se encontró. ID inválido");
        
        errors.add(error);
        Gson gson = new Gson();
        String errorsJson = gson.toJson(errors);

        return errorsJson;
    }
    
    /**
     * Procesa la solicitud desde el cliente de acuerdo al protocolo enviado.
     * @param requestJson Srting. Pedido desde el cliente en formato de Json.
     */
    @Override
    protected void processRequest(String requestJson) {
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);

        switch (protocolRequest.getResource()) {
            case "food":
                if (protocolRequest.getAction().equals("get")) {
                    try {
                        processGetFood(protocolRequest);
                    } catch (Exception ex) {
                        Logger.getLogger(RestaurantServerSocket.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (protocolRequest.getAction().equals("post")) {
                    try {
                        processAddFood(protocolRequest);
                        } catch (Exception ex) {
                        Logger.getLogger(RestaurantServerSocket.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
                break;
        }

    }
    
    /**
     * Inicializa el servicio del repositorio y el server.
     * @return this RestaurantServerSocket. instancia del server inicializada.
     */
    @Override
    protected ServerSocketTemplate init() {
        PORT = Integer.parseInt(Utilities.loadProperty("server.port"));
        IFoodRepository repository = Factory.getInstance().getRepository("default");
        this.setService(new FoodService(repository));
        return this;
    }
}
