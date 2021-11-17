/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;


/**
 * Calculadora del costo de parking correspondiente a un Camion 
 * @fecha 2021/11/17
 * @author Miguel Mosquera, Sebastian Arenas
 */
public class TruckParkingCost implements IParkingCost{

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        long result;
        
        int totalDias = output.getDayOfMonth() - input.getDayOfMonth();
        int totalHoras = output.getHour() - input.getHour();

        if (totalHoras <= 12 && totalDias == 0) {
            result = 10000;
        } else {
            if (totalHoras > 12 && totalHoras <= 24 && totalDias == 0) {
                result = 15000;
            } else {
                result = 15000 + (((totalDias - 1) * 24 + totalHoras) * 15000) / 24;
            }
        }
        
        return ((result + 99) / 100) * 100;
    }
    
}
