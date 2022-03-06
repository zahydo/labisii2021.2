/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.app;

import co.unicauca.restaurant.server.infra.RestaurantServerSocket;

/**
 *
 * @author 57322
 */
public class RestaurantApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RestaurantServerSocket server = new RestaurantServerSocket();
        server.startServer();
    }

}
