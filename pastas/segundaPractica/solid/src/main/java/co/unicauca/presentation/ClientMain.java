package co.unicauca.presentation;

import java.time.Duration;
import java.time.LocalDateTime;

public class ClientMain {

    public static void main(String[] args) {
        final long DAY_RATE = 15000;
        final long MIN_RATE = 10000;

        LocalDateTime input = LocalDateTime.of(2021, 11, 11, 1, 0);
        LocalDateTime output = LocalDateTime.of(2021, 11, 14, 2, 0);

        long days = 0, cost = 0;

        Duration duration = Duration.between(input, output);
        double rate;

        if (duration.toHours() <= 12) {
            System.out.println(MIN_RATE);
        }

        if (duration.toHours() > 12 && duration.toHours() < 24) {
            System.out.println(MIN_RATE);
        }

        days = duration.toDays();
        long extraHours = ((duration.toHours() % 24));

        rate = (double) extraHours / 24;

        long extra = (long) (rate * DAY_RATE - (rate * DAY_RATE % 100)) + 100;

        System.out.println(extra);

        cost = (long) (DAY_RATE * days + extra);

        System.out.println(cost);
    }

}