/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;
import java.time.Duration;

/**
 *
 * @author cristiancast
 */
public class MotoParkingCost implements IParkingCost {

    /**
     * Calcula el costo de parqueo por minuto
     *
     * @param veh
     * @param input
     * @param output
     * @return costo por minuto
     */
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
