/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;
import java.time.LocalDateTime;

/**
 * Interfaz para calcular el costo del parqueadero de cualquier tipo de
 * vehiculo: carro, moto, camión
 *
 * @author Libardo
 */
public interface IParkingCost {
    /**
     * Permite calcular el valor a pagar en el parqueadero 
     * @param veh Vehiculo
     * @param input Fecha y hora de ingreso al parqueadero
     * @param output Fecha y hora de salida del parqueadero
     * @return Valor a pagar en el parqueadero
     */
    long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output);
}
