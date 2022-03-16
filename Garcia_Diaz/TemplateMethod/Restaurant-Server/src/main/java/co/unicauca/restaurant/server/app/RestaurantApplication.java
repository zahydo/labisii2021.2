
package co.unicauca.restaurant.server.app;

import co.unicauca.restaurant.server.infra.RestaurantServerSocket;

/**
 *
 * @author Anderson Diaz
 */
public class RestaurantApplication {


    public static void main(String[] args) {
        RestaurantServerSocket server = new RestaurantServerSocket();
        server.startServer();
    }
    
}
