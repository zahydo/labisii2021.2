package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class TruckParkingCost implements IParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        long valorhora = 15000 / 24;
        long coste;
        long horaT = Duration.between(input, output).toHours();
        int dia = (int) horaT / 24;
        long hora = horaT - (dia * 24);
        if (horaT < 12) {
            coste = 10000;
        } else if (horaT < 24) {
            coste = 15000;
        } else {
            coste = (dia * 15000) + (hora * valorhora);
        }
        return ((coste + 99) / 100) * 100;
    }

}