/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.client.app;

import co.unicauca.restaurant.client.access.Factory;
import co.unicauca.restaurant.client.access.IRestaurantAccess;
import co.unicauca.restaurant.client.domain.services.RestaurantService;
import co.unicauca.travelagency.commons.domain.Food;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 57322
 */
public class RestaurantClientApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Servicio
        IRestaurantAccess service = Factory.getInstance().getRestaurantService();
        RestaurantService restaurantService = new RestaurantService(service);
        try {
            /*Solicitar Platos*/
            Food response = restaurantService.getFood("1");
            System.out.println("Plato Obtenido:" + response.toString());
            response = restaurantService.getFood("2");
            System.out.println("Plato Obtenido:" + response.toString());
            response = restaurantService.getFood("3");
            System.out.println("Plato Obtenido:" + response.toString());
            response = restaurantService.getFood("4");
            System.out.println("Plato Obtenido:" + response.toString());
            response = restaurantService.getFood("5");
            System.out.println("Plato Obtenido:" + response.toString());
            /*Guardar Platos*/
            restaurantService.postFood(new Food("20", "Comida 1 desde Cliente", 15000, 0));
            restaurantService.postFood(new Food("21", "Comida 2 desde Cliente", 13000, 0));
            restaurantService.postFood(new Food("22", "Comida 3 desde Cliente", 14000, 0));
            restaurantService.postFood(new Food("23", "Comida 4 desde Cliente", 18000, 0));
            restaurantService.postFood(new Food("24", "Comida 5 desde Cliente", 17000, 0));
            restaurantService.postFood(new Food("25", "Comida 6 desde Cliente", 19000, 0));

        } catch (Exception ex) {
            Logger.getLogger(RestaurantClientApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
