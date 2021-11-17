package com.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class TruckParkingCost implements IParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        Duration varDur = Duration.between(input, output);
        if (varDur.toHours() < 12){
            return 10000;
        } else if (varDur.toHours() > 12 && varDur.toHours() < 24){
            return 15000;
        } else {
            long varDays = varDur.toDays();
            long varHours = varDur.minus(Duration.ofDays(varDays)).toHours();
            return (15000*varDays) + (long) (Math.ceil((((varHours*15000)/24.0)/100.0))*100.0);
        }
    }
    
}
