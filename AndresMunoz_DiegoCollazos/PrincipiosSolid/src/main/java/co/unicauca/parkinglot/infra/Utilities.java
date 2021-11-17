/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.infra;

import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;

/**
 *
 * @author ASUS
 */
public class Utilities {
    
    public Utilities(){}; 
    
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output){
        if (veh == null || input == null || output == null){
            return -1;  
        }
        IParkingCost park = ParkingCostFactory.getInstance().getParkingCost(veh.getType()); 
        return park.calculateCost(veh, input, output); 
    }
    
}
