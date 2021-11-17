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
 * @author cristiancast
 */
public class CarParkingCost implements IParkingCost {

    /**
     * Calcula el costo de parqueo por minuto
     *
     * @param veh
     * @param input
     * @param output
     * @return Costo por minuto
     */
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
