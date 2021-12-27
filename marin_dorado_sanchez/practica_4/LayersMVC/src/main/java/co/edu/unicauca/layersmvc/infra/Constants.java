/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.layersmvc.infra;

/**
 *
 * @author Fabián David Marín, Héctor Fernando Dorado, Juán Sebastíán Sánchez
 */
public class Constants {

    /*Declara el servidor local para la base de daatos y el tipo de mensajería para RabbitMQ*/
    public final static String HOST_NAME = "localhost";
    public final static String EXCHANGE_TYPE = "fanout";

    /**
     * Método estático que no retorna un valor; muestra la lista de los productos almacenados
     * 
     * @param list
     */
    public static void printStringList(String[] list) {
        for (String item : list) {
            System.out.println(item);
        }
    }
}
