package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class TruckParkingCost implements IParkingCost{
    public TruckParkingCost() {
    }
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        Duration d1 = Duration.between(input, output); 
        double horas = d1.toMinutes()/60; 
        long cost = 0; 
        
        if(horas > 12 && horas <= 24){
            cost = 15000; 
        }else if(horas <= 12){
            cost = 10000; 
        }else {
            double costodias = (horas/24.00)*15000;  
            cost = (long)Math.ceil(costodias/1000)*1000;  
        }
        return cost; 
    }

    
}
