package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class MotoParkingCost implements IParkingCost{

    //TODO: implementar el metodo calculateCost en MotoParkingCost
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
    	 long duracion = Duration.between(input, output).toMinutes();
         long duracionHoras = duracion / 60; 
         long duracionMinutos = duracion % 60;
         long valorPagar;
         
        if(duracionHoras == 0 && duracionMinutos > 0) {
     	   valorPagar = 1000;
        }
        else if(duracionHoras == 1 && duracionMinutos == 0) {
     	   valorPagar = 2000;
        }
        else {
     	   valorPagar = 2000+((duracionHoras-1)*1000) +( ((duracionMinutos*1000)/60));
        }
        
         valorPagar =  ((valorPagar+100)/100)*100;
         return valorPagar;
    }
    
}
