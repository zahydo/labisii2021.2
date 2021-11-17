/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 *
 * @author Yahir Garcés
 */
public class MotoParkingCost implements IParkingCost{

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        long result = 0;
        int vdia = 12000;
        int dia = output.getDayOfYear() - input.getDayOfYear();
        int hora = output.getHour() - input.getHour();
        int minuto = output.getMinute() - input.getMinute();
        
        if (hora < 0) {
            dia = dia - 1;
            hora = 24 + hora;
        }
         
        if(minuto < 0){
            hora = hora - 1;
            minuto = 60 + minuto;
        }
        
        if (hora < 0) {
            hora = 24 + hora;
        }
        
        if (hora >= 1) {
            hora = 2000 + (hora - 1) * 1000;
            minuto = (minuto * 1000) / 60;
            result = hora + minuto + (vdia*dia);
        } else {
            result = 1000;
        }
        
        return ((result+99)/100)*100;
    }

   
}
