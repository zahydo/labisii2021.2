/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.client.infra.RestaurantSocket;
import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.travelagency.commons.infra.JsonError;
import co.unicauca.travelagency.commons.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author David E
 */
public class FoodAccessImplSockets implements IFoodAccess{
    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private RestaurantSocket mySocket;

    public FoodAccessImplSockets() {
        mySocket = new RestaurantSocket();
    }

    /**
     * Crea una Food. Utiliza socket para pedir el servicio al servidor
     *
     * @param food comida del restaurante
     * @return devuelve el id de la comida
     * @throws Exception error crear la comida
     */
    @Override
    public String createFood(Food food) throws Exception {
        String jsonResponse = null;
        String requestJson = createCustomerRequestJson(food);
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
                //Agregó correctamente, devuelve el id del plato
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
     * @param idFood identificación de la comida
     * @return solicitud de consulta del cliente en formato Json.
     */
    private String findFoodRequestJson(String idFood) {
        
        Protocol protocol = new Protocol();
        protocol.setResource("food");
        protocol.setAction("get");
        protocol.addParameter("id", idFood);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Crea la solicitud json de creación de la comida para ser enviado por el
     * socket
     *
     * @param customer objeto customer
     * @return devulve la requestJson
     */
    private String createCustomerRequestJson(Food food) {

        Protocol protocol = new Protocol();
        protocol.setResource("food");
        protocol.setAction("post");
        protocol.addParameter("id", String.valueOf(food.getId()) );
        protocol.addParameter("Name", food.getName());
        protocol.addParameter("Type", food.getType().toString() );

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

    
    /**
     * Busca una Food. Utiliza socket para pedir el servicio al servidor
     * @param id id de la comida
     * @return Devuelve la comida
     * @throws Exception 
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
                //Encontró el customer
                Food food = jsonToFood(jsonResponse);
                return food;
            }
        }
    }
}
