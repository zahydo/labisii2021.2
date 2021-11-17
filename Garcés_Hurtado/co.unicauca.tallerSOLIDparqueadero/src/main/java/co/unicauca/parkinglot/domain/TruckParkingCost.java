/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 *
 * @author Yahir Garcés
 */
public class TruckParkingCost implements IParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        long result = 0;
        int dia = output.getDayOfYear() - input.getDayOfYear();
        int hora = output.getHour() - input.getHour();

        if (hora < 0) {
            dia = dia - 1;
            hora = 24 + hora;
        }

        if (dia == 0) {
            if (hora <= 12) {
                result = 10000;
            } else {
                result = 15000;
            }
        } else if (dia >= 1) {
            dia = 15000 * dia;
            hora = (hora * 15000) / 24;
            result = dia + hora;
        } else {
            result = 10000;
        }
        return ((result+99)/100)*100;
    }

}
