/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.domain;

import static java.lang.Math.ceil;
import java.time.LocalDateTime;

/**
 *
 * @author David E
 */
public class CarParkingCost implements IParkingCost{

    /**
     * calcula el costo del parking para carros
     * @param vehiculo, fecha de entrada del vehiculo, fecha de salida del behiculo
     * 
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        double horas = output.getHour() - input.getHour();
        double minutos = 0;
        if(input.getMinute() > output.getMinute()){
            minutos = input.getMinute() - output.getMinute();
        }else{
            minutos = output.getMinute() - input.getMinute();
        }

        double costo;
        int costoHora = 4000;
        
        if(horas < 1){
            costo = costoHora - 2000;
        }else if(horas == 1){
            costo =((minutos/60)* (costoHora-2000)) + costoHora ;
            
        }else{
            costo = costoHora + ((horas-1)*(costoHora-2000)) + ((minutos/60)*(costoHora-2000));
        }
        
        costo = ((ceil(costo*0.01))*100);
        
        return (long)costo;
    }
    
}
