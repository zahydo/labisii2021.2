package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class MotoParkingCost implements IParkingCost{

    String informacionSorteo = "";  
    boolean ganoSorteo = false; 
    
    
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        Duration d1 = Duration.between(input, output); 
        double horas = d1.toMinutes()/60.00;
        long cost = 0; 
        if(ganoSorteo){
            return 0; 
        }
        if(horas < 1){
            cost = 1000; 
        }else if(horas == 1){
            cost = 2000;
        }else{
            double costo = 2000 + (horas - 1)*1000;
            cost = (long)Math.ceil(costo/1000)*1000;
        }
        return cost; 
    }
    
    public void sorteo(int number){
        int valor = (int)Math.floor(Math.random()*1001);  
        if(valor< 0 || valor > 1000){
            informacionSorteo = "número inválido";
            ganoSorteo  = false; 
        }else if(valor == number){
            informacionSorteo = "Ganó sorteo"; 
            ganoSorteo = true;  
        }else {
            informacionSorteo = "no ganó sorteo"; 
            ganoSorteo = false; 
        }
    }
        
    public String getInformacionSorteo(){
        return informacionSorteo;  
    }
}
