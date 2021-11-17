package co.unicauca.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class CarParkingCost implements IParkingCost {
    static final long MIN_RATE = 1000;
    static final long FIXED_RATE = 2000;

    public CarParkingCost() {
    };

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {

        long hours = 0, minutes = 0, cost = 0;

        Duration duration = Duration.between(input, output);
        double rate;

        if (duration.toHours() < 1) {
            return MIN_RATE;
        } else {

            hours = duration.toHours();
            long extra_hours = 0;

            if (hours >= 2) {
                extra_hours = MIN_RATE * (hours - 1);
            }

            minutes = ((duration.getSeconds() % 3600) / 60);

            rate = (double) minutes / 60;

            long extra = (long) (rate * MIN_RATE - (rate * MIN_RATE % 100)) + 100;

            cost = (long) (FIXED_RATE + extra_hours + extra);

            return cost;
        }
    }
}
