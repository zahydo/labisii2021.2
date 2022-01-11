/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.layersmvc.infra;

/**
 *
 * @author 57322
 */
public class Constants {

    public final static String HOST_NAME = "localhost";
    public final static String EXCHANGE_TYPE = "fanout";

    public static void printStringList(String[] list) {
        for (String item : list) {
            System.out.println(item);
        }
    }
}
