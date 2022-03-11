package co.unicauca.travelagency.server.app;

import co.unicauca.travelagency.server.infra.RestaurantServerSocket;

/**
 * Aplicación principal que lanza el servidor en un hilo
 * 
 * @author Libardo, Julio
 */
public class AgenciaViajesApplication {
    public static void main(String args[]) {
        RestaurantServerSocket server = new RestaurantServerSocket();
        server.startServer();
    }
}
