/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkingflot.domain;

import java.time.Duration;
import java.time.LocalDateTime;


/**
 *
 * @author ASUS
 */
public class MotoParkingCost implements IParkingCost{

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        Duration d1 = Duration.between(input, output); 
        double horas = d1.toMinutes()/60.00; 
        long cost = 0; 
        if(horas < 1){
            cost = 1000; 
        }else if(horas == 1){
            cost = 2000;
        }else{
            double fraccion = horas%1;
        }
        return cost; 
    }

    
    
}
