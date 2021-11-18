/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author Dz
 */
public class MotoParkingCost implements lParkingCost{

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        Duration Dur = Duration.between(input, output);
        if (Dur.toHours() < 1){
            return 1000;
        } else {
            Dur = Dur.minus(Duration.ofMinutes(60));
            return 2000 + (long) ((Math.ceil(((Dur.toMinutes()*1000.0)/60.0)/100.0))*100.0);
        }
    }

}
