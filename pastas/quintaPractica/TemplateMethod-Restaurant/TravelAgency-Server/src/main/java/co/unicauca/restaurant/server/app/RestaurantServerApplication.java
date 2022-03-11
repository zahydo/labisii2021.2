package co.unicauca.restaurant.server.app;

import co.unicauca.restaurant.server.infra.RestaurantServerSocket;

/**
 * Aplicación principal que lanza el servidor en un hilo
 * @author Libardo, Julio
 */
public class RestaurantServerApplication {
    public static void main(String args[]){
        RestaurantServerSocket server = new RestaurantServerSocket();
        server.startServer();
    }
}
