package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

public interface IParkingCost {

    /**
     * Interfaz para calcular el costo del parqueadero de cualquier tipo de
     * vehiculo: carro, moto, camión
     *
     * @author Libardo
     * @param veh
     * @param input
     * @param output
     * @return
     */
    long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output);
}
