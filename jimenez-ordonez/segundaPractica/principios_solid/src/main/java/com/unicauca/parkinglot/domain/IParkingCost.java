package com.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

public interface IParkingCost {

    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output);

}
