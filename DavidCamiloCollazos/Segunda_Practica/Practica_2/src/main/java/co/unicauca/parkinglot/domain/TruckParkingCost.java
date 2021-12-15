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
public class TruckParkingCost implements IParkingCost{

    /**
     * calcula el costo del parking para TRUCKS
     * @param vehiculo, fecha de entrada del vehiculo, fecha de salida del behiculo
     * 
     */
    
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        double dias = (output.getDayOfYear() - input.getDayOfYear());
        double horas = output.getHour() - input.getHour();
        double costo;
        int costoDia = 15000;
        
        if(output.getHour() < input.getHour() && dias > 0){
            dias --;
        }
        
        if(dias == 1 && horas == 0){
            costo = costoDia;
        }else if(dias == 0 && horas <= 12){
            costo = costoDia-5000;
            
        }else if(dias == 0 && horas > 12 && horas < 24){
            costo = costoDia;
        }else{
            costo = (dias*costoDia) + ( (horas/24) * costoDia);
        }
        
        costo = ((ceil(costo*0.01))*100);
        
        return (long)costo;
    }
    
}
