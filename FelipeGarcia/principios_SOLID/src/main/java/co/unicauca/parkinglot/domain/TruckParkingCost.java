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
public class TruckParkingCost implements IParkingCost {

    /**
     * Calcula el costo por dias y horas de un camion
     *
     * @param veh
     * @param input
     * @param output
     * @return coste, long
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        long valorhora = 15000 / 24;
        long coste;
        long horaT = Duration.between(input, output).toHours();
        int dia = (int) horaT / 24;
        long hora = horaT - (dia * 24);
        if (horaT < 12) {
            coste = 10000;
        } else if (horaT < 24) {
            coste = 15000;
        } else {
            coste = (dia * 15000) + (hora * valorhora);
        }
        return ((coste + 99) / 100) * 100;
    }

}
