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
 * Esta clase permite calcular el costo del parqueadero para un carro
 * @author YAQUE
 */
public class CarParkingCost implements IParkingCost{

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
            return 2000;
        }
        else if(t==1){
            return 4000;
        }
        else{
            return (long)(Utilities.redondeo((t-1)*2000+4000));
        }
    }
    
}
