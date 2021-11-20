/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.domain;

import co.unicauca.parkinglot.infra.Utilities;
import java.time.LocalDateTime;

/**
 *
 * @author Antonio E
 */
public class TruckParkingCost implements IParkingCost {

    public TruckParkingCost() {
    }
    
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        int vDife[] = Utilities.getDif(input, output);
        int horas = vDife[0]*24+vDife[1];
        int minutos = vDife[2];
        long result;

        if ((horas<=11 && minutos<=59) || (horas==12 && minutos==0)) {
            return 10000;
        }else if((horas<=23 && minutos<=59) || (horas==24 && minutos==0)){
            return 15000;
        }else{
            float aux = ((float)(15000*vDife[1]))/24;
            result = vDife[0]*15000 + (long)aux;
        }
        return Utilities.round(result);
    }

    
}
