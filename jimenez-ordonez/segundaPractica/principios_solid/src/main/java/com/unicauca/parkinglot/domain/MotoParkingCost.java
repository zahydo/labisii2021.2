package com.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class MotoParkingCost implements IParkingCost{

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        Duration varDur = Duration.between(input, output);
        if (varDur.toHours() < 1){
            return 1000;
        } else {
            varDur.minus(Duration.ofHours(1));
            return (long) Math.ceil(2000 + ((varDur.toMinutes()*1000)/60));
        }
    }
    
}
