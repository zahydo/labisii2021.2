/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 *  Interfaz CostoEstacionamiento 
 * @author Kevin Daryany Morales
 */
public interface IParkingCost {

  long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output);
    
}
