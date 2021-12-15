package com.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class CarParkingCost implements IParkingCost {

    
    /** 
     * Calculo del costo del servicio de parque para tipo CAR
     * @param veh
     * @param input
     * @param output
     * @return long
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        Duration varDur = Duration.between(input, output);
        if (varDur.toHours() < 1){
            return 2000;
        } else {
            varDur = varDur.minus(Duration.ofMinutes(60));
            return 4000 + (long) ((Math.ceil(((varDur.toMinutes()*2000.0)/60.0)/100.0))*100.0);
        }
    }
    
}
