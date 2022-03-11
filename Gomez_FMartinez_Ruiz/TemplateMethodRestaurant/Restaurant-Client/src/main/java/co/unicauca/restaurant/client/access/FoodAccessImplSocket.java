package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.client.infra.RestaurantSocket;
import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.commons.infra.JsonError;
import co.unicauca.restaurant.commons.infra.Protocol;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XssIsor
 */
public class FoodAccessImplSocket implements IFoodAccess{
    
     /**
     * Socket de comunicación para el servicio de acceso.
     */
    private RestaurantSocket socket;

    /**
     * Constructor.
     * Inicializa el Socket.
     */
    public FoodAccessImplSocket() {
        socket = new RestaurantSocket();
    }
    

    /**
     * Crea la solicitud de búsqueda para una comida de acuerdo a un protocolo en formato JSon.
     * @param id String. Identificador de la comida a agregar.
     * @return requestJson String. La solicitud de la consulta del cliente en formato Json.
     */
    private String findFoodJson(String id) {
        Protocol protocol = new Protocol();
        
        protocol.setResource("food");
        protocol.setAction("get");
        protocol.addParameter("id", id);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Crea la solicitud de creación de una nueva comida de acuerdo a un protocolo en formato JSon.
     * @param food Food. Comida a crear.
     * @return requestJson String. La solicitud de creación en formato JSon.
     */
    private String createFoodJson(Food food) {

        Protocol protocol = new Protocol();
        
        protocol.setResource("food");
        protocol.setAction("post");
        protocol.addParameter("id", String.valueOf(food.getId()) );
        protocol.addParameter("Name", food.getName());
        protocol.addParameter("Type", food.getType().toString() );
        
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }
    
    /**
     * Obtiene los mensajes de error.
     * @param response String. Lista de errores en formato JSon.
     * @return messages String. Mensajes de error.
     */
    private String extractMessages(String response) {
        JsonError[] messagesErrors = jsonToErrors(response);
        String messages = "";
        
        for (JsonError error : messagesErrors) {
            messages += error.getMessage();
        }
        return messages;
    }

    /**
     * Conversor de mensajes de JSon a JsonError que los guarda en un Array.
     * @param jsonError String. Errores en formato JSon.
     * @return errors JsonError[]. Lista de errores.
     */
    private JsonError[] jsonToErrors(String jsonErrorList) {
        Gson gson = new Gson();
        
        JsonError[] errors = gson.fromJson(jsonErrorList, JsonError[].class);
        return errors;
    }

    /**
     * Conversor de Json a Food.
     * @param jsonFood String. Comida enviada en formato JSon.
     */
    private Food jsonToFood(String jsonFood) {

        Gson gson = new Gson();
        Food food = gson.fromJson(jsonFood, Food.class);

        return food;
    }

    /**
     * Sobreeescritura de IFoodAccess. Función de búsqueda de comida. 
     * Envía la petición al Socket.
     * @param id String. Identificador de la comida.
     * @return food Food. Comida encontrada.
     * @throws Exception Si hay algún problema con la consulta o la conexión al server.
     */
    @Override
    public Food findFood(String id) throws Exception {
        String requestJson = findFoodJson(id);
        String response = null;
        
        try {
            socket.connect();
            response = socket.sendStream(requestJson);
            
            socket.closeStream();
            socket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(FoodAccessImplSocket.class.getName()).log(Level.SEVERE, "No se pudo conectar con el servidor", ex);
        }
        
        if (response == null) {
            throw new Exception("Imposible conectar con el servidor. Vuelva a intentarlo asegurandose que está corriendo");
        } else {
            if (response.contains("error")) {
                Logger.getLogger(FoodAccessImplSocket.class.getName()).log(Level.INFO, response);
                throw new Exception(extractMessages(response));
            } else {
                Food food = jsonToFood(response);
                return food;
            }
        }
    }
    
    /**
     * Sobreescritura de IFoodAcess. Función de creación de una nueva comida.
     * Envía la petición al Socket.
     * @param food Food. Comida a agregar.
     * @return String. Identificador de la comida agregada.
     * @throws Exception Si hay algún problema con la creación de la comida o la conexión al server.
     */
    @Override
    public String createFood(Food food) throws Exception {
        
        String requestJson = createFoodJson(food);
        String response = null;
        
        try {
            socket.connect();
            response = socket.sendStream(requestJson);
            socket.closeStream();
            socket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(FoodAccessImplSocket.class.getName()).log(Level.SEVERE, "No se pudo conectar con el servidor", ex);
        }
        if (response == null) {
            throw new Exception("Imposible conectar con el servidor. Vuelva a intentarlo asegurandose que está corriendo");
        } else {

            if (response.contains("error")) {             
                Logger.getLogger(FoodAccessImplSocket.class.getName()).log(Level.INFO, response);
                throw new Exception(extractMessages(response));
            } else {
                return String.valueOf(food.getId());
            }

        }

    }
}
