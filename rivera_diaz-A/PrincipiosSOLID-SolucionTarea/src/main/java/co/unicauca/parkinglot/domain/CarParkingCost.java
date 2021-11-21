package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author andersondiaz
 */
public class CarParkingCost implements lParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {

        Duration Dur = Duration.between(input, output);
        if (Dur.toHours() < 1) {
            return 2000;
        } else {
            Dur = Dur.minus(Duration.ofMinutes(60));
            return 4000 + (long) ((Math.ceil(((Dur.toMinutes() * 2000.0) / 60.0) / 100.0)) * 100.0);
        }

    }

}
