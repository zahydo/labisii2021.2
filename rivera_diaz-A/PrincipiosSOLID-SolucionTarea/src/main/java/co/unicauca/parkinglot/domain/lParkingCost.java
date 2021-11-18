package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 *
 * @author andersondiaz
 */
public interface lParkingCost {

    long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output);

}
