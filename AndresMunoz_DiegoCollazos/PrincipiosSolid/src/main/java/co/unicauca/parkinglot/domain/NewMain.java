/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author ASUS
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalDateTime ldt1 = LocalDateTime.of(2017, 07, 06, 23, 30, 00);
        LocalDateTime ldt2;
        ldt2 = LocalDateTime.of(2017, 07, 7, 23, 40, 00);
        Duration d1 = Duration.between(ldt1, ldt2);
        Duration d2 = Duration.ofHours(8);
        double horas = d1.toMinutes()/64.00; 
        System.out.println(horas%1);
        
        if (d1.compareTo(d2) > 0) {
            System.out.println(d1);
        } else {
            System.out.println("do something");
        }
    }

}
