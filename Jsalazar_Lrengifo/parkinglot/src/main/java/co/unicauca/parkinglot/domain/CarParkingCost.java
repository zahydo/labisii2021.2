package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;


public class CarParkingCost implements IParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        long valormin = 2000 / 60;
        long coste;
        long minT = Duration.between(input, output).toMinutes();
        int hora = (int) minT / 60;
        long min = minT - (hora * 60);
        if (hora < 1) {
            coste = 2000;
        } else {
            coste = 4000 + ((hora - 1) * 2000) + (min * valormin);
        }
        return ((coste + 99) / 100) * 100;
    }

}