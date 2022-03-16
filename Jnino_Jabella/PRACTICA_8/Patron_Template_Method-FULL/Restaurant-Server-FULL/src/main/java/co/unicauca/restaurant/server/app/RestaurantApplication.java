/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.unicauca.restaurant.server.app;

import co.unicauca.restaurant.server.infra.RestaurantServerSocket;

/**
 *
 * @author Libardo, Julio
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
