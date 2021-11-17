package com.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

public class MotoParkingCost implements IParkingCost{

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        
        return 0;
    }
    
}
