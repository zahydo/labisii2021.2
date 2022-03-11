package co.unicauca.restaurant.server.app;

import co.unicauca.restaurant.server.infra.RestaurantServerSocket;

/**
 *
 * @author XssIsor
 */
public class RestaurantApp {
    
     /**
     * Ejecución principal para iniciar con los servicios del server
     * @param args 
     */
    public static void main(String args[]){
        RestaurantServerSocket server = new RestaurantServerSocket();
        server.startServer();
    }
}
