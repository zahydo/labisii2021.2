package com.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class MotoParkingCost implements IParkingCost{

    
    /** 
     * Calculo del costo del servicio de parque para tipo MOTO
     * @param veh
     * @param input
     * @param output
     * @return long
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        Duration varDur = Duration.between(input, output);
        if (varDur.toHours() < 1){
            return 1000;
        } else {
            varDur = varDur.minus(Duration.ofMinutes(60));
            return 2000 + (long) ((Math.ceil(((varDur.toMinutes()*1000.0)/60.0)/100.0))*100.0);
        }
    }
    
}
