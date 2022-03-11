/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import co.unicauca.restaurant.client.access.Factory;
import co.unicauca.restaurant.client.access.IRestaurantAccess;
import co.unicauca.restaurant.client.domain.services.RestaurantService;
import co.unicauca.travelagency.commons.domain.Food;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 57322
 */
public class RestaurantTest {

    /**
     * Prueba de petición GET al servidor
     */
    @Test
    public void testRequestGetRestaurant() {
        System.out.println("Petición GET al servidor");
        //Servicio
        IRestaurantAccess service = Factory.getInstance().getRestaurantService();
        RestaurantService restaurantService = new RestaurantService(service);
        try {
            assertEquals("Hamburguesa", restaurantService.getFood("1").getNameFood());
            assertEquals("Pechuga Gratinada", restaurantService.getFood("2").getNameFood());
            assertEquals("Pizza", restaurantService.getFood("3").getNameFood());
            assertEquals("Aborrajado", restaurantService.getFood("4").getNameFood());
            assertEquals("Estofado", restaurantService.getFood("5").getNameFood());
            assertEquals("Carne a la parrilla", restaurantService.getFood("6").getNameFood());

        } catch (Exception ex) {
            Logger.getLogger(RestaurantTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Prueba de petición POST al servidor
     */
    @Test
    public void testRequestPostRestaurant() {
        System.out.println("Petición POST al servidor");
        //Servicio
        IRestaurantAccess service = Factory.getInstance().getRestaurantService();
        RestaurantService restaurantService = new RestaurantService(service);
        try {
            assertEquals("20", restaurantService.postFood(new Food("20", "Comida 1 desde Cliente", 15000, 0)));
            assertEquals("21", restaurantService.postFood(new Food("21", "Comida 2 desde Cliente", 15000, 0)));
            assertEquals("22", restaurantService.postFood(new Food("22", "Comida 3 desde Cliente", 15000, 0)));
            assertEquals("23", restaurantService.postFood(new Food("23", "Comida 4 desde Cliente", 15000, 0)));
            assertEquals("24", restaurantService.postFood(new Food("24", "Comida 5 desde Cliente", 15000, 0)));
            assertEquals("25", restaurantService.postFood(new Food("25", "Comida 6 desde Cliente", 15000, 0)));

        } catch (Exception ex) {
            Logger.getLogger(RestaurantTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
