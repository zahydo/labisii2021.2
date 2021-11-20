package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 *
 * @author jnino_jabella
 */
public interface lParkingCost {

    long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output);
}
