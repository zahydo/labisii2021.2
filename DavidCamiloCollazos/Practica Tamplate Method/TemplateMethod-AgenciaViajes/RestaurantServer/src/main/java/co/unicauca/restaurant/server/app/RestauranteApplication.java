/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.server.app;

import co.unicauca.restaurant.server.infra.ServerSocketRestaurant;

/**
 *
 * @author David E
 */
public class RestauranteApplication {
    /**
     * Main para iniciar el servidor.
     * @param args 
     */
    public static void main(String args[]){
        ServerSocketRestaurant server = new ServerSocketRestaurant();
        server.startServer();
    }
}
