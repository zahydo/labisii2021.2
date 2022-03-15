/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.server.app;

import co.unicauca.restaurant.server.app.infra.RestaurantServerSocket;

/**
 *
 * @author Jose Ricardo
 */
public class RestaurantAplication {
    public static void main(String args[]) {
        RestaurantServerSocket servidor = new RestaurantServerSocket();
        servidor.startServer();
    }
}
