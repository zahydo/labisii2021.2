package co.unicauca.restaurant.server.app;

import co.unicauca.restaurant.server.infra.ServerSocketRestaurant;

/**
 * Aplicación principal que lanza el servidor en un hilo
 * @author Libardo, Julio
 */
public class RestaurantApplication {
    public static void main(String args[]){
        ServerSocketRestaurant server = new ServerSocketRestaurant();
        server.startServer();
    }
}
