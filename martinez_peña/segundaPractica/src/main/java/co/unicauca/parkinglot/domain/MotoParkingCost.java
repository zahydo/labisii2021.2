/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 *
 * @author 57322
 */
public class MotoParkingCost implements IParkingCost {

    /**
     * Method: This is a method for calculate the cost in a vehicle of type:
     * Moto
     *
     * @param veh
     * @param input
     * @param output
     * @return
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {

        //Valores
        long valorFijo = 2000;
        double horas = 0;
        double minutos = 0;
        int dias = 0;
        minutos = Math.abs(output.getMinute() - input.getMinute());//Se obtiene el valor absoluto de la diferencia de la diferencia de los minutos d esalida y entrada
        dias = output.getDayOfYear() - input.getDayOfYear();//En caso de se haya estado más de un día
        horas = output.getHour() - input.getHour() + (24 * dias) + (minutos / 60); //Calcula las horas + los días en horas + los minutos en horas
        if (horas < 1 && dias == 0 && minutos < 60) { //Si estuvo menos d euna hora, salga
            return 1000;
        }

        long result = valorFijo + Math.round((horas - 1.0) * 1000); //Si estuvo más de una hora
        float r = (float) result / 100;
        r = (float) Math.ceil((double) r);
        r = (r) * 100;
        result = (new Double(r)).longValue();
        return result;
    }

}
