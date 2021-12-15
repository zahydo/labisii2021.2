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
 * @author Andres Garcia
 * @author Felipe Garcia
 */
public class MotoParkingCost implements IParkingCost {

    /**
     * Calcula el costo por horas y minutos de una moto
     *
     * @param veh
     * @param input
     * @param output
     * @return coste, long
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        long valormin = 1000 / 60;
        long coste;
        long minT = Duration.between(input, output).toMinutes();
        int hora = (int) minT / 60;
        long min = minT - (hora * 60);
        if (hora < 1) {
            coste = 1000;
        } else {
            coste = 2000 + ((hora - 1) * 1000) + (min * valormin);
        }
        return ((coste + 99) / 100) * 100;
    }

}
