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
 * @author Julio, Libardo
 */
public class FoodAccessImplSockets implements IFoodAccess {

    private RestaurantSocket mySocket;

    public FoodAccessImplSockets (){
        mySocket = new RestaurantSocket();
    }
    
    @Override
    public Food findFood(String id) throws Exception {

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
                //Errores
                Logger.getLogger(FoodAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontrada
                Food food = jsonToFood(jsonResponse);
                return food;
            }
        }

    }


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
                //Agregó correctamente, devuelve la cedula del customer 
                return food.getId();
            }

        }

    }


    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }


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
        protocol.addParameter("id", food.getId());
        protocol.addParameter("name", food.getName());
        protocol.addParameter("description", food.getDescription());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

        return requestJson;
    }


    private Food jsonToFood(String jsonFood) {

        Gson gson = new Gson();
        Food food = gson.fromJson(jsonFood, Food.class);

        return food;
    }

}
