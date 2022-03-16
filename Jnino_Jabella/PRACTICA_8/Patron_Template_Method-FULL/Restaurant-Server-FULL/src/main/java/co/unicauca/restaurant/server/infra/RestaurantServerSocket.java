/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.server.infra;

import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.commons.domain.FoodTypeEnum;
import co.unicauca.restaurant.commons.infra.JsonError;
import co.unicauca.restaurant.commons.infra.Protocol;
import co.unicauca.restaurant.commons.infra.Utilities;
import co.unicauca.restaurant.server.access.Fabrica_Repositorio;
import co.unicauca.restaurant.server.domain.services.Servicio_Comida;
import co.unicauca.serversocket.serversockettemplate.infra.ServerSocketTemplate;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import co.unicauca.restaurant.server.access.Interface_Repositorio_Comida;

/**
 *
 * @author Libardo, Julio
 */
public class RestaurantServerSocket extends ServerSocketTemplate{
    
    /**
     * Servicio de clientes
     */
    private Servicio_Comida service;

    public RestaurantServerSocket() {
    }

    
    
    
    @Override
    protected ServerSocketTemplate init() {
        PORT = Integer.parseInt(Utilities.loadProperty("server.port"));
        Interface_Repositorio_Comida repo = Fabrica_Repositorio.getInstance().getRepository("default");
        this.setService(new Servicio_Comida(repo));
        return this;
    }
    
    
    /**
     * Procesar la solicitud que proviene de la aplicación cliente
     *
     * @param requestJson petición que proviene del cliente socket en formato
     * json que viene de esta manera:
     * "{"resource":"food","action":"get","parameters":[{"name":"id","value":"1"}]}"
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
                    // Consultar un customer
                    processGetFood(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un customer    
                    processPostFood(protocolRequest);

                }
                break;
        }
    }
    
    /**
     * Procesa la solicitud de consultar un food
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetFood(Protocol protocolRequest) {
        // Extraer la cedula del primer parámetro
        String id = protocolRequest.getParameters().get(0).getValue();
        Food food = getService().findByIdl(Integer.parseInt (id));
        if (food == null) {
            String errorJson = generateNotFoundErrorJson();
            respond(errorJson);
        } else {
            respond(objectToJSON(food));
        }
    }
    
    /**
     * Procesa la solicitud de agregar un customer
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processPostFood(Protocol protocolRequest) {
        Food food = new Food();
        // Reconstruir el customer a partid de lo que viene en los parámetros
        food.setIdFood(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        food.setNameFood(protocolRequest.getParameters().get(1).getValue());
        food.setType(FoodTypeEnum.valueOf(protocolRequest.getParameters().get(2).getValue()));

        boolean response = getService().create(food);
        if(response){
            respond("Comida creada con exito");
        }else{
            respond("La comida no ha sido creada");
        }
    }
    
    
   
    public Servicio_Comida getService() {
        return service;
    }

    public void setService(Servicio_Comida service) {
        this.service = service;
    }

    private String generateNotFoundErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("404");
        error.setError("NOT_FOUND");
        error.setMessage("Comida no encontrada. Comida no existe");
        errors.add(error);

        Gson gson = new Gson();
        String errorsJson = gson.toJson(errors);

        return errorsJson;
    }
    
    
    
}
