package co.unicauca.foodapp.server.app;

import co.unicauca.foodapp.server.infra.ServerSocketRestaurant;

/**
 * Aplicación principal que lanza el servidor en un hilo
 * @author Libardo, Julio
 */
public class FoodServerApplication {

    /**
     * Función main 
     * @param args
     */
    public static void main(String args[]){
        ServerSocketRestaurant server = new ServerSocketRestaurant();
        server.startServer();
    }
}
