package co.unicauca.Restaurante.client.access;

import co.unicauca.Restaurante.commons.domain.Food;
import co.unicauca.Restaurante.commons.infra.JsonError;
import co.unicauca.Restaurante.commons.infra.Protocol;
import co.unicauca.Restaurante.client.infra.TravelAgencySocket;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servicio de Cliente. Permite hacer el CRUD de clientes solicitando los
 * servicios con la aplicación server. Maneja los errores devueltos
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class FoodAccessImplSockets implements IFoodAccess {

    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private TravelAgencySocket mySocket;

    public FoodAccessImplSockets() {
        mySocket = new TravelAgencySocket();
    }

    /**
     * Busca un Food. Utiliza socket para pedir el servicio al servidor
     *
     * @param id cedula del cliente
     * @return Objeto Food
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public Food findFood(String id) throws Exception {
        //{"id"="9800001", "nombres":"juan", "apellidos":"perez", "direcciones":"[{}, {}, {}]"}
        String jsonResponse = null;
        String requestJson = findFoodRequestJson(id);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el food
                Food food = jsonToFood(jsonResponse);
                return food;
            }
        }

    }

    /**
     * Crea un Food. Utiliza socket para pedir el servicio al servidor
     *
     * @param food cliente de la agencia de viajes
     * @return devuelve la cedula del cliente creado
     * @throws Exception error crear el cliente
     */
    @Override
    public String createFood(Food food) throws Exception {
        String jsonResponse = null;
        String requestJson = createFoodRequestJson(food);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve la cedula del food 
                return String.valueOf(food.getId());
            }

        }

    }
    /**
     * Extra los mensajes de la lista de errores
     * @param jsonResponse lista de mensajes json
     * @return Mensajes de error
     */
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }

    /**
     * Convierte el jsonError a un array de objetos jsonError
     *
     * @param jsonError
     * @return objeto MyError
     */
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     *
     * @param idFood identificación del cliente
     * @return solicitud de consulta del cliente en formato Json, algo como:
     * {"resource":"food","action":"get","parameters":[{"name":"id","value":"98000001"}]}
     */
    private String findFoodRequestJson(String idFood) {
        //{"recource":"food", "action":"get", "parametrers":"[{"name": "id", "value": 9800001"},{}]"}
        Protocol protocol = new Protocol();
        protocol.setResource("food");
        protocol.setAction("get");
        protocol.addParameter("id", idFood);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Crea la solicitud json de creación del food para ser enviado por el
     * socket
     *
     * @param food objeto food
     * @return devulve algo como:
     * {"resource":"food","action":"post","parameters":[{"name":"id","value":"980000012"},{"name":"fistName","value":"Juan"},...}]}
     */
    private String createFoodRequestJson(Food food) {

        Protocol protocol = new Protocol();
        protocol.setResource("food");
        protocol.setAction("post");
        protocol.addParameter("id", String.valueOf(food.getId()));
        protocol.addParameter("Name", food.getName());
        protocol.addParameter("Type", food.getType().toString());
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

        return requestJson;
    }

    /**
     * Convierte jsonFood, proveniente del server socket, de json a un
     * objeto Food
     *
     * @param jsonFood objeto cliente en formato json
     */
    private Food jsonToFood(String jsonFood) {

        Gson gson = new Gson();
        Food food = gson.fromJson(jsonFood, Food.class);

        return food;

    }

}
