/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author Daniel Cerón
 */
public class CarParkingCost implements IParkingCost {

    /**
     * @param veh the vehicle
     * @param input in  
     * @param output
     * @return coste by hours and minutes
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        long valormin = 2000 / 60;
        long cost;
        long minT = Duration.between(input, output).toMinutes();
        int hora = (int) minT / 60;
        long min = minT - (hora * 60);
        if (hora < 1) {
            cost = 2000;
        } else {
            cost = 4000 + ((hora - 1) * 2000) + (min * valormin);
        }
        return ((cost + 99) / 100) * 100;
    }
}