package co.unicauca.domain;

import java.time.Duration;
import java.time.LocalDateTime;
import co.unicauca.infra.Utilities;

public class TruckParkingCost implements IParkingCost {

    static final long DAY_RATE = 15000;
    static final long MIN_RATE = 10000;

    public TruckParkingCost() {
    };

    
    /** 
     * Calculates parking rate given a vehicle, entry time and departure time.
     * Returns the minimal rate if parking duration is below 12 hours
     * returns the day rate if the parking durations is between 12-24 hours
     * otherwise calculates the days and the rate for day fractions(hours)
     * @param veh
     * @param input
     * @param output
     * @return long
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {

        long days = 0, cost = 0;

        Duration duration = Duration.between(input, output);
        double rate;

        if (duration.toHours() <= 12) {
            return MIN_RATE;
        }

        if (duration.toHours() > 12 && duration.toHours() < 24) {
            return DAY_RATE;
        }

        days = duration.toDays();
        long extraHours = ((duration.toHours() % 24));

        rate = (double) extraHours / 24;

        long extra = (long) (rate * DAY_RATE);

        if(extra % 100 != 0){
            extra = extra - (extra%100) + 100;
        }

        cost = (long) (DAY_RATE * days + extra);

        if(Utilities.lottery()){
            return 0;
        }

        return cost;
       

    }
}
