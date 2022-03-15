/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.server.app.infra;

import co.unicauca.restaurant.common.domain.Food;
import co.unicauca.restaurant.common.domain.JsonError;
import co.unicauca.restaurant.common.domain.Protocol;
import co.unicauca.restaurant.server.app.access.Factory;
import co.unicauca.restaurant.server.app.access.IFoodRepository;
import co.unicauca.restaurant.server.app.services.FoodService;
import co.unicauca.serversocket.serversockettemplate.helpers.Utilities;
import co.unicauca.serversocket.serversockettemplate.infra.ServerSocketTemplate;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose Ricardo
 */
public class RestaurantServerSocket extends ServerSocketTemplate {
    private FoodService service;

    
    
    @Override
    protected ServerSocketTemplate init() {
        PORT = Integer.parseInt(Utilities.loadProperty("server.port"));
        IFoodRepository repository = Factory.getInstance().getRepository();
        service = (new FoodService(repository));
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
                    // Consultar un Food
                    processGetFood(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un Food
                    processPostFood(protocolRequest);

                }
                break;
        }

    }

    private void processGetFood(Protocol protocolRequest) {
        // Extraer el id del primer parámetro
        String id = protocolRequest.getParameters().get(0).getValue();
        Food food = service.findByIdl(Integer.parseInt(id));
        if (food == null) {
            String errorJson = generateNotFoundErrorJson();
            respond(errorJson);
        } else {
            respond(objectToJSON(food));
        }
    }
    
     protected void processPostFood(Protocol protocolRequest) {
        Food food = new Food();
        food.setId(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        food.setName(protocolRequest.getParameters().get(1).getValue());
        String response = service.create(food);
        respond(response);
    }

    
    
    private String generateNotFoundErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("404");
        error.setError("NOT_FOUND");
        error.setMessage("No se encontró la comida");
        errors.add(error);
        Gson gson = new Gson();
        String errorsJson = gson.toJson(errors);
        return errorsJson;
    }
   
}
