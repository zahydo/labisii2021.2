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
public class CarParkingCost implements IParkingCost {

    public CarParkingCost() {
    }

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        int vDife[] = Utilities.getDif(input, output);
        int horas = vDife[0]*24+vDife[1];
        int minutos = vDife[2];
        long result;
        
        if (horas<1) {
            return 2000;
        }else{
            float aux = ((float)minutos/60)*2000;
            result = 4000 + (horas - 1)*2000 + (long)aux ;        
        }
        return Utilities.round(result);
    }
    
}