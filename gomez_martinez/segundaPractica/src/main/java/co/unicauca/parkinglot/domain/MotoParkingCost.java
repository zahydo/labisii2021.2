package co.unicauca.parkinglot.domain;

import co.unicauca.parkinglot.infra.Utilities;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author angiecgomez
 * @author mafemartinez
 */
public class MotoParkingCost implements IParkingCost {

    /**
     * Calculate the total parking cost for a motorcycle according to minutes
     * @param veh
     * @param input Check-In Time
     * @param output Check-Out Time
     * @return rate, total parking cost
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        
        long rate = 0;
        
        long totalT = Duration.between(input, output).toMinutes();
        
        if(totalT < 60){
            rate = 1000;
        } else {
            double total = totalT;
            double time = total/60;
            
            long round = (long) (2000 + 1000*(time-1));
            rate = Utilities.round(round);  
        }
        return rate;    
    }
    
}
