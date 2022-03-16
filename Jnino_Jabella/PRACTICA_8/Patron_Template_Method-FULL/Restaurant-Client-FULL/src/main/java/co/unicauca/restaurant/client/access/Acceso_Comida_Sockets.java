/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.client.infra.Conexion_Restaurante;
import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.commons.infra.JsonError;
import co.unicauca.restaurant.commons.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Libardo, Julio
 */
public class Acceso_Comida_Sockets implements Interface_Acceso_Comida {

    private Conexion_Restaurante atrSocket;

    /*
      Constructor - Inicializa el atributo atrSocket
     */
    public Acceso_Comida_Sockets() {
        atrSocket = new Conexion_Restaurante();
    }

    /*
       Este metodo encuentra comida por su id
       @Param id, entero que contine el id de la comida a buscar
       @return retorna el objeto comida que se encontro.
     */
    @Override
    public Food EncontrarComida(int id) throws Exception {
        String jsonResponse = null;
        String requestJson = findFoodRequestJson(id);
        try {
            atrSocket.Conectar();
            jsonResponse = atrSocket.EnviarSeñal(requestJson);
            atrSocket.CerrarSeñal();
            atrSocket.Desconectar();

        } catch (IOException ex) {
            Logger.getLogger(Acceso_Comida_Sockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                Logger.getLogger(Acceso_Comida_Sockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                Food food = jsonToFood(jsonResponse);
                return food;
            }
        }
    }

    private String findFoodRequestJson(int idFood) {
        //{"recource":"customer", "action":"get", "parametrers":"[{"name": "id", "value": 9800001"},{}]"}
        Protocol protocol = new Protocol();
        protocol.setResource("food");
        protocol.setAction("get");
        protocol.addParameter("id", String.valueOf(idFood));

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private Food jsonToFood(String jsonFood) {

        Gson gson = new Gson();
        Food food = gson.fromJson(jsonFood, Food.class);

        return food;

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

    private String createFoodRequestJson(Food food) {

        Protocol protocol = new Protocol();
        protocol.setResource("food");
        protocol.setAction("post");
        protocol.addParameter("id", String.valueOf(food.getIdFood()));
        protocol.addParameter("name", food.getNameFood());
        protocol.addParameter("type", String.valueOf(food.getType()));

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

        return requestJson;
    }

    /*
      Este Metodo devuelve la identificacion de la comida que se le pase por parametro
      @Param Recibe como parabetro un objeto de tipo comida
      @return String con el id de la comida.
     */
    @Override
    public String CrearComida(Food food) throws Exception {
        String jsonResponse = null;
        String requestJson = createFoodRequestJson(food);
        try {
            atrSocket.Conectar();
            jsonResponse = atrSocket.EnviarSeñal(requestJson);
            atrSocket.CerrarSeñal();
            atrSocket.Desconectar();

        } catch (IOException ex) {
            Logger.getLogger(Acceso_Comida_Sockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(Acceso_Comida_Sockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve la cedula del customer 
                return String.valueOf(food.getIdFood());
            }

        }
    }

}
