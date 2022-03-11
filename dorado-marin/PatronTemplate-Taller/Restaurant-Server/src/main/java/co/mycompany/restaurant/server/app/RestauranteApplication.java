package co.mycompany.restaurant.server.app;

import co.mycompany.restaurant.server.infra.ServerSocketRestaurant;

/**
 * @author Fabián David Marín - Hector Fernando Dorado
 * 
 * En esta clase se inicia el servidor
 */

public class RestauranteApplication {
    public static void main(String args[]){
        ServerSocketRestaurant server = new ServerSocketRestaurant();
        server.startServer();
    }
}
