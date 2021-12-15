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
 * class TruckParkingCost
 * Esta clase permite calcular el costo del parqueadero para un camion
 * @author YAQUE
 */
public class TruckParkingCost implements IParkingCost{

    /**
     * Metodo que permite calcular el valor a pagar en el parqueadero 
     * @param veh Vehiculo
     * @param input Fecha y hora entrada
     * @param output Fecha y hora salida 
     * @return Valor a pagar en el parqueadero
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        double t = (ChronoUnit.HOURS.between(input,output));
        if (t<=12){
            return 10000;
        }
        if (t>12&&t<=24){
            return 15000;
        }
        else{
            return (long)(Utilities.redondeo((t*15000)/24));
        }
    }
    
}
