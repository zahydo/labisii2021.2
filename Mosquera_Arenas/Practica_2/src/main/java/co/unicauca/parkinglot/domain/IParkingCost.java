/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 * Interfaz que cominica los tipos de vehiculos con las gestion de los Servicios
 * @fecha 2021/11/17
 * @author Miguel Mosquera, Sebastian Arenas
 */
public interface IParkingCost {
    
    /** 
     * Metodo que calcula el costo de parking segun el tipo de vehiculo 
     * @ param vehiculo, fecha de entrada del vehiculo, fecha de salida del vehiculo
     * @return costo del parking 
     */
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output);
}
