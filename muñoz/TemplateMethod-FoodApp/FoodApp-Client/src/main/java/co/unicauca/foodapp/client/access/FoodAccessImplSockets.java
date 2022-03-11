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
 * Servicio de Cliente. Permite hacer el CRUD de clientes solicitando los
 * servicios con la aplicación server. Maneja los errores devueltos
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class FoodAccessImplSockets implements IFoodAccess {

    private FoodSocket mySocket;

    /**
     * Constructor por defecto 
     */
    public FoodAccessImplSockets() {
        mySocket = new FoodSocket();
    }

    /**
     *
     * @param id de la comida a buscar 
     * @return Food comida encontrada o nulo si no la encuentra 
     * @throws Exception
     */
    @Override
    public Food findFood(String id) throws Exception {

        String requestJson = findFoodRequestJson(id);
        String jsonResponse = request(requestJson);

        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                return null;
            } else {
                //Encontró el customer
                Food food = jsonToFood(jsonResponse);
                return food;
            }
        }

    }

    /**
     * Solicita la creación de ua comida 
     * @param food comida a crear 
     * @return String mensaje de éxito o fallo 
     * @throws Exception
     */
    @Override
    public String createFood(Food food) throws Exception {

        String requestJson = createFoodRequestJson(food);
        String jsonResponse = request(requestJson);
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                return jsonResponse;
            } else {
                //Agregó correctamente, devuelve la cedula del customer 
                return String.valueOf(food.getId());
            }

        }

    }

    /**
     * Solicita el borrado de una comida 
     * @param id id de la comida a borrar 
     * @return String mensaje de fallo o éxito de la transacción 
     * @throws Exception
     */
    @Override
    public String delete(int id) throws Exception{
        String jsonResponse = null;
        String requestJson = doDeleteFoodRequestJson(id);
        jsonResponse = request(requestJson);
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve la cedula del cita 
                return "Elemento " + id + " eliminado";
            }

        }
    }

    /**
     * Actualiza una comida 
     * @param food comida a actualizar 
     * @return String mensaje de acierto o fallo 
     * @throws Exception
     */
    @Override
    public String update(Food food) throws Exception  {
        String requestJson = updateFoodRequestJson(food);
        String jsonResponse = request(requestJson);
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                return jsonResponse;
            } else {
                //Agregó correctamente, devuelve la cedula del customer 
                return String.valueOf(food.getId());
            }

        }

    }

    /**
     * Solicita el retorno de la lista de alimentos disponibles
     * @return List<Food> nulo si la lista está vacía, lista de foods en caso contrario
     * @throws Exception
     */
    @Override
    public List<Food> findAll() throws Exception {
        String requestJson = doFindAllRequestJson();
        String jsonResponse = request(requestJson);

        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else if (jsonResponse.toLowerCase().contains("info:")) {
                Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: (" + jsonResponse.toString() + ")");
                return null;
            } else {
                //Encontró las citas
                List<Food> foods = jsonToList(jsonResponse);
                Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: (" + jsonResponse.toString() + ")");
                return foods;
            }
        }

    }

    private List<Food> jsonToList(String jsonLista) {
        if (jsonLista.contains("info:")) {
            return null;
        } else {
            Gson gson = new Gson();
            Type type2 = new TypeToken<List<Food>>() {
            }.getType();
            List<Food> aux = gson.fromJson(jsonLista, type2);
            return aux;
        }
    }

    /**
     * Extra los mensajes de la lista de errores
     *
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

    private String findFoodRequestJson(String idFood) {

        Protocol protocol = new Protocol();
        protocol.setResource("food");
        protocol.setAction("get");
        protocol.addParameter("id", idFood);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private String createFoodRequestJson(Food food) {

        Protocol protocol = new Protocol();
        protocol.setResource("food");
        protocol.setAction("post");
        protocol.addParameter("id", String.valueOf(food.getId()));
        protocol.addParameter("nombre", food.getName());
        protocol.addParameter("type", food.getType().toString());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }
    
    private String doDeleteFoodRequestJson(int id) {
        Protocol protocol = new Protocol();
        protocol.setResource("food");
        protocol.setAction("delete");
        protocol.addParameter("id", String.valueOf(id));
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        
        return requestJson;
    }

    
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
    
    private String doFindAllRequestJson() {
        Protocol protocol = new Protocol();
        protocol.setResource("food");
        protocol.setAction("findall");

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private Food jsonToFood(String jsonFood) {

        Gson gson = new Gson();
        Food food = gson.fromJson(jsonFood, Food.class);

        return food;

    }

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

   
    

}
