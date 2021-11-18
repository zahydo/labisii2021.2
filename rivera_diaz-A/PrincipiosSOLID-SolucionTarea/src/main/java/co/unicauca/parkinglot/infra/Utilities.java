/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.infra;

/**
 *
 * @author Dz
 */
import co.unicauca.parkinglot.domain.lParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;

public class Utilities {

    public Utilities() {
    }

    ; 
    
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        if (veh == null || input == null || output == null) {
            return -1;
        }
        lParkingCost park = ParkingCostFactory.getInstance().getParkingCost(veh.getType());
        return park.calculateCost(veh, input, output);
    }

}
