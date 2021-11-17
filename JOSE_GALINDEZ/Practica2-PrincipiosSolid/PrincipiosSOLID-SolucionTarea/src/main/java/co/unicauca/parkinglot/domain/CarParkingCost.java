/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import co.unicauca.parkinglot.infra.Utilities;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Permite calcular el costo de parquiadero para un Auto
 * @author Jose_R
 */
public class CarParkingCost implements IParkingCost {
    /**
     * Metodo para calcular el coste de parqueo de un auto
     * @param veh vehiculo al que se le calculará la tarifa
     * @param input hora de entrada del vehiculo al parqueadero
     * @param output hora de salida del vehiculo al parqueadero
     * @return Costo total del servicio de paqueo para dicho vehiculo
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        double t = (ChronoUnit.MINUTES.between(input, output) / 60.0);
        if (t <= 1) {
            return 2000;
        } else {
            long aux = Utilities.redondeo((t - 1) * 2000 + 4000);
            return aux;
        }
    }

}
