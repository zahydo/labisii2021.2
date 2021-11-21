package co.unicauca.parkinglot.domain;

import co.unicauca.parkinglot.infra.Utilities;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author angiecgomez
 * @author mafemartinez
 */
public class TruckParkingCost implements IParkingCost {

    /**
     * Calculate the total parking cost for a truck according to hours
     * @param veh
     * @param input
     * @param output
     * @return rate, total parking cost
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        String plate = veh.getPlate();
        int num = (int) plate.charAt(plate.length()-1);
        
        double prize = Math.random()*10;
        if(prize == num){
            return 0;
        }
        
        long rate = 0;
        
        long totalT = Duration.between(input, output).toHours();
        
        if(totalT == 24){
            rate = 15000;
        }else if(totalT <= 12){
            rate = 10000;
        }else if(totalT > 12 && totalT < 24){
            rate = 15000;
        }else{
            double total = totalT;
            double time = total/24;
            
            long round = (long) (15000 * time);
            rate = Utilities.round(round);

        }
        return rate;
    }
    
}
