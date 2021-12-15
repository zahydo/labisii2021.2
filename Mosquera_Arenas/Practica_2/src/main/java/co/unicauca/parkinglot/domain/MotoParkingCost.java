/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Calculadora del costo de parking correspondiente a una Moto 
 * @fecha 2021/11/17
 * @author Miguel Mosquera, Sebastian Arenas
 */
public class MotoParkingCost implements IParkingCost{

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        
        long result = 0;

        Duration duration = Duration.between(input, output);
        long minutosTotales = duration.toMinutes();
        long minutosTranscurridos = output.getMinute() - input.getMinute();
        long totalHoras = duration.toHours();

        if (minutosTotales <= 60) {
            result = 1000;
        } else {
            result = 2000 + (((totalHoras - 1) * 60 + minutosTranscurridos) * 1000) / 60;
            //1h 1000 /  
        }
        return ((result + 99) / 100) * 100;
    }
    
}
