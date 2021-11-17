/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkingflot.domain;

import java.time.Duration;
import java.time.LocalDateTime;


/**
 *
 * @author ASUS
 */
public class CarParkingCost implements IParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        return 0; 
    }

    
    
}
