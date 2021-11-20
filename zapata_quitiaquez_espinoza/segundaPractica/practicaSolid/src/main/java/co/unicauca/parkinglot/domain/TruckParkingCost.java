package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class TruckParkingCost implements IParkingCost{

    //TODO: implementar el metodo calculateCost en TruckParkingCost
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
    	 long totalCost = 0;
         int totalTime = (int)Duration.between(input, output).toMinutes();
         int totalDays = totalTime/1440;
         totalTime -= totalDays*1440;
         int totalHours = totalTime/60;
         if(totalDays == 0 && totalHours <= 12) totalCost = 10000;
         if(totalDays == 0 && totalHours > 12) totalCost = 15000;
         if(totalDays > 0){
             totalCost = totalDays * 15000;
             totalCost = totalCost + (totalHours * 15000 / 24);
         }
         totalCost =  ((totalCost+100)/100)*100;
         return(totalCost);
    }
    
}
