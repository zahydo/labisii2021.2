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
 * Permite calcular el costo de parquiadero para un Camión
 * @author Jose_R
 */
public class TruckParkingCost implements IParkingCost {
    /**
     * Metodo para calcular el coste de parqueo de un Camion
     * @param veh vehiculo al que se le calculará la tarifa
     * @param input hora de entrada del vehiculo al parqueadero
     * @param output hora de salida del vehiculo al parqueadero
     * @return Costo total del servicio de paqueo para dicho vehiculo
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        double t = (ChronoUnit.HOURS.between(input, output));
        if (t <= 12) {
            return 10000;
        } else if (t > 12 && t <= 24) {
            return 15000;
        } else {
            long aux = Utilities.redondeo((t * 15000) / 24);
            return aux;
        }
    }

}
