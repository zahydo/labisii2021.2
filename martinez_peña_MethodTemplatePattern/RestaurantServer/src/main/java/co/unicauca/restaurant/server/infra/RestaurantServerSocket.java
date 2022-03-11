/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.infra;

import co.unicauca.restaurant.server.access.Factory;
import co.unicauca.restaurant.server.access.IRepository;
import co.unicauca.restaurant.server.domain.services.FoodService;
import co.unicauca.serversocket.serversockettemplate.infra.ServerSocketTemplate;
import co.unicauca.travelagency.commons.domain.Food;
import co.unicauca.travelagency.commons.infra.JsonError;
import co.unicauca.travelagency.commons.infra.Protocol;
import co.unicauca.travelagency.commons.infra.Utilities;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julián Martinez, Paula Peña
 */
public class RestaurantServerSocket extends ServerSocketTemplate {

    /**
     * Servicio de comidas
     */
    private FoodService service;

    /**
     * Constructor
     */
    public RestaurantServerSocket() {
    }

    @Override
    protected ServerSocketTemplate init() {
        PORT = Integer.parseInt(Utilities.loadProperty("server.port"));
        //Se hace la inyección de dependencia
        IRepository repository = Factory.getInstance().getRepository();
        this.setService(new FoodService(repository));
        return this;
    }

    @Override
    protected void processRequest(String requestJson) {
        // Convertir la solicitud a objeto Protocol para poderlo procesar
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);

        switch (protocolRequest.getResource()) {
            case "food":
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar una comida
                    processGetFood(protocolRequest);
                }
                if (protocolRequest.getAction().equals("post")) {
                    // Agregar comida   
                    processPostFood(protocolRequest);
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
        Food food = getService().obtenerPlato(id);
        if (food == null) {
            String errorJson = generateNotFoundErrorJson();
            //Esto viene de la platilla suministrada
            respond(errorJson);
        } else {
            respond(objectToJSON(food));
        }
    }

    /**
     * Procesa la solicitud de agregar una comida
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processPostFood(Protocol protocolRequest) {
        Food food = new Food();
        // Reconstruir la comida a partir de los parámetros del protocolo
        food.setId(protocolRequest.getParameters().get(0).getValue());
        food.setNameFood(protocolRequest.getParameters().get(1).getValue());
        food.setPrecio(Float.parseFloat(protocolRequest.getParameters().get(2).getValue()));
        food.setDescuento(Float.parseFloat(protocolRequest.getParameters().get(3).getValue()));
        String response = getService().crearPlato(food);
        respond(response);
    }

    /**
     * Genera un error en formato Json
     * @return El error 404 en formato Json
     */
    private String generateNotFoundErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("404");
        error.setError("NOT_FOUND");
        error.setMessage("Comida no encontrada");
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
