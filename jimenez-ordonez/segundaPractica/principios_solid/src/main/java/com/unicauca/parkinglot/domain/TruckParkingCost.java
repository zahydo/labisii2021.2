package com.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class TruckParkingCost implements IParkingCost {

    
    /** 
     * Calculo del costo del servicio de parque para tipo TRUCK
     * @param veh
     * @param input
     * @param output
     * @return long
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        if (sorteo()){
            return 0;
        }
        Duration varDur = Duration.between(input, output);
        if (varDur.toHours() < 12){
            return 10000;
        } else if (varDur.toHours() > 12 && varDur.toHours() < 24){
            return 15000;
        } else {
            long varDays = varDur.toDays();
            long varHours = varDur.minus(Duration.ofDays(varDays)).toHours();
            return (15000*varDays) + (long) (Math.ceil((((varHours*15000)/24.0)/100.0))*100.0);
        }
    }

    
    /** 
     * Retorna si el camion gano o no el servicio gratis
     * @return boolean
     */
    private boolean sorteo(){
        Random varRand = new Random();
        int varNum = varRand.nextInt(1000) + 1;
        return (varRand.nextInt(1000)+1) == varNum;
    }
    
}
