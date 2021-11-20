package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 * @author angiecgomez
 * @author mafemartinez
 */
public interface IParkingCost {
    
    /**
     * Abstract methods that must be implemented by the inheriting classes
     */
    
    /**
     * Calculate the total parking cost of a vehicle according to minutes, hours 
     * or according to the implementation of each inheriting class
     * @param veh
     * @param input
     * @param output
     * @return long
     */
    long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output);
}
