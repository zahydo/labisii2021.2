/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;
import co.unicauca.parkinglot.infra.Utilities;

/**
 * Interfaz para calcular el costo del parqueadero de cualquier tipo de
 * vehiculo: carro, moto, camión
 *
 * @author Jose_R
 */
public interface IParkingCost {

    long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output);
}
