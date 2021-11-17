package co.unicauca.domain;

import java.time.LocalDateTime;

public interface IParkingCost {
    public abstract long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output);
}
