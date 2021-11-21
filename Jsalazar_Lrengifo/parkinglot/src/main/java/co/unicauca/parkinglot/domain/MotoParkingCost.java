package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;


public class MotoParkingCost implements IParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        long valormin = 1000 / 60;
        long coste;
        long minT = Duration.between(input, output).toMinutes();
        int hora = (int) minT / 60;
        long min = minT - (hora * 60);
        if (hora < 1) {
            coste = 1000;
        } else {
            coste = 2000 + ((hora - 1) * 1000) + (min * valormin);
        }
        return ((coste + 99) / 100) * 100;
    }

}