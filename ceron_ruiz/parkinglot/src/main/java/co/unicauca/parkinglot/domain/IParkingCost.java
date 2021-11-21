/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.domain;
import java.time.LocalDateTime;

/**
 * @author Daniel Cerón
 */
public interface IParkingCost {

    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output);
}
