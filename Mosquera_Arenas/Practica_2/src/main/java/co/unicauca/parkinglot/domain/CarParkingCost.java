/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;


/**
 * Calculadora del costo de parking correspondiente a un carro 
 * @fecha 2021/11/17
 * @author Miguel Mosquera, Sebastian Arenas
 */
public class CarParkingCost implements IParkingCost{

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        
        long result;

        Duration duration = Duration.between(input, output);
        long minutosTotales = duration.toMinutes();
        long minutosTranscurridos = output.getMinute() - input.getMinute();
        long totalHoras = duration.toHours();

        if (minutosTotales <= 60) {
            result = 2000;
        } else {
            result = 4000 + (((totalHoras - 1) * 60 + minutosTranscurridos) * 2000) / 60;
        }
        return ((result + 99) / 100) * 100;
    }
    
}
