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
 * Esta clase permite calcular el costo del parqueadero para una moto
 * @author YAQUE
 */
public class MotoParkingCost implements IParkingCost{

    /**
     * Metodo que permite calcular el valor a pagar en el parqueadero 
     * @param veh Vehiculo
     * @param input Fecha y hora entrada
     * @param output Fecha y hora salida 
     * @return Valor a pagar en el parqueadero
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        double t = (ChronoUnit.MINUTES.between(input,output)/60.0);
        if (t<1){
            return 1000;
        }
        else {
            return (long)(Utilities.redondeo((t-1)*1000+2000));
        }
    }
    
}
