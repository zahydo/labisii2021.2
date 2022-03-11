package co.unicauca.foodapp.client.access;

import co.unicauca.foodapp.commons.domain.Food;
import co.unicauca.foodapp.commons.infra.JsonError;
import co.unicauca.foodapp.commons.infra.Protocol;
import co.unicauca.foodapp.client.infra.FoodSocket;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servicio de Food. Permite hacer el CRUD de foods solicitando los
 * servicios con la aplicación server. Maneja los errores devueltos
 *
 * @author Diego Collazos, Eliana Cerquera
 */
public class FoodAccessImplSockets implements IFoodAccess {

    /**
     * Instancia del socket de infra 
     */
    private FoodSocket mySocket;

    /**
     * Constructor por defecto
     */
    public FoodAccessImplSockets() {
        mySocket = new FoodSocket();
    }

    
    @Override
    public Food find(String id) throws Exception {
        String requestJson = doFindFoodRequestJson(id);
        String jsonResponse = request(requestJson);
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        }
        if (jsonResponse.contains("error")) { //Devolvió algún error
            Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
            return null;
        }
        return jsonToFood(jsonResponse); //Encontró el customer
    }
    /**
     * Metodo auxiliar que crea el protocolo necesario en json
     * para que el serversocket pueda encontrar comida por su ID
     * @param id de la Food a encontrar
     * @return String con el protocolo en Json
     */
    private String doFindFoodRequestJson(String id) {
        Protocol protocol = new Protocol();
        protocol.setResource("food");
        protocol.setAction("get");
        protocol.addParameter("id", id);

        Gson gson = new Gson();
        return gson.toJson(protocol);
    }

    @Override
    public String create(Food food) throws Exception {
        String requestJson = doCreateFoodRequestJson(food);
        String jsonResponse = request(requestJson);
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        }
        if (jsonResponse.contains("error")) { //Devolvió algún error
            Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
            return jsonResponse;
        } 
        return String.valueOf(food.getId()); // Creó la comida, devuelve su id
    }
    /**
     * Metodo auxiliar que crea el protocolo necesario en json
     * para que el serversocket pueda crear un Food
     * @param Food objeto al que extraer los datos de construccion
     * @return String con el protocolo en Json
     */
    private String doCreateFoodRequestJson(Food food) {
        Protocol protocol = new Protocol();
        protocol.setResource("food");
        protocol.setAction("post");
        protocol.addParameter("id", String.valueOf(food.getId()));
        protocol.addParameter("nombre", food.getName());
        protocol.addParameter("type", food.getType().toString());

        Gson gson = new Gson();
        return gson.toJson(protocol);
    }

    @Override
    public String delete(int id) throws Exception{
        String jsonResponse = null;
        String requestJson = doDeleteFoodRequestJson(id);
        jsonResponse = request(requestJson);
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        }
        if (jsonResponse.contains("error")) { //Devolvió algún error
            Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
            throw new Exception(extractMessages(jsonResponse));
        }
        return "Elemento " + id + " eliminado"; // Eliminó, devuelve la id
    }
    /**
     * Metodo auxiliar que crea el protocolo necesario en json
     * para que el serversocket pueda eliminar comida por su ID
     * @param id de la Food a eliminar
     * @return String con el protocolo en Json
     */
    private String doDeleteFoodRequestJson(int id) {
        Protocol protocol = new Protocol();
        protocol.setResource("food");
        protocol.setAction("delete");
        protocol.addParameter("id", String.valueOf(id));
        
        Gson gson = new Gson();
        return gson.toJson(protocol);
    }

    @Override
    public String update(Food food) throws Exception  {
        String requestJson = updateFoodRequestJson(food);
        String jsonResponse = request(requestJson);
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        }
        if (jsonResponse.contains("error")) { //Devolvió algún error
            Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
            return jsonResponse;
        }
        return String.valueOf(food.getId()); // Actualizó correctamente, devuelve la id
    }
    /**
     * Metodo auxiliar que crea el protocolo necesario en json
     * para que el serversocket pueda actualizar un Food
     * @param Food nuevo que se actualizara
     * @return String con el protocolo en Json
     */
    private String updateFoodRequestJson(Food food) {
        Protocol protocol = new Protocol();
        protocol.setResource("food");
        protocol.setAction("update");
        protocol.addParameter("id", String.valueOf(food.getId()));
        protocol.addParameter("nombre", food.getName());
        protocol.addParameter("type", food.getType().toString());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);
        return requestJson;
    }

    @Override
    public List<Food> findAll() throws Exception {
        String requestJson = doFindAllRequestJson();
        String jsonResponse = request(requestJson);
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        }
        if (jsonResponse.contains("error")) { //Devolvió algún error
            Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
            throw new Exception(extractMessages(jsonResponse));
        }
        if (jsonResponse.toLowerCase().contains("info:")) {
            Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: (" + jsonResponse.toString() + ")");
            return null;
        } 
        return jsonToList(jsonResponse); //Encontró las comidas
    }
    /**
     * Metodo auxiliar que crea el protocolo necesario en json
     * para que el serversocket pueda listar todos los Food
     * @return String con el protocolo en Json
     */
    private String doFindAllRequestJson() {
        Protocol protocol = new Protocol();
        protocol.setResource("food");
        protocol.setAction("findall");

        Gson gson = new Gson();
        return gson.toJson(protocol);
    }

    /**
     * Construye una lista de Food a partir de un json
     * @param jsonLista contiene los datos de varios objetos Food en json
     * @return Lista de objetos Food
     */
    private List<Food> jsonToList(String jsonLista) {
        if (jsonLista.contains("info:")) {
            return null;
        }
        Gson gson = new Gson();
        Type type2 = new TypeToken<List<Food>>() {}.getType();
        return gson.fromJson(jsonLista, type2);
    }

    /**
     * Convierte el jsonError a un array de objetos jsonError
     * @param jsonError json con informacion de errores
     * @return Array de JsonError
     */
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }

    /**
     * Construye un objeto Food a partir de un json
     * @param jsonFood con la informacion de Food
     * @return objeto Food
     */
    private Food jsonToFood(String jsonFood) {
        Gson gson = new Gson();
        return gson.fromJson(jsonFood, Food.class);
    }

    /**
     * Conecta el socket y envia la informacion en json al serversocket
     * @param requestJson con la informacion a enviar
     * @return respuesta del servidor en json
     */
    private String request(String requestJson) {
        String jsonResponse = null;
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        return jsonResponse;
    }
    
    /**
     * Extrae el mensaje de una jsonResponse por parte del serversocket
     * @param jsonResponse con la informacion en formato json
     * @return String con el mensaje
     */
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }
}
