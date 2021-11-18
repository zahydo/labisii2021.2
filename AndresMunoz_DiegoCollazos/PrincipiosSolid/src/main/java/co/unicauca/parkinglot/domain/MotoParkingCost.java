package co.unicauca.parkinglot.domain;
/**
* +--------------------------------------------------------------------------------------+
* | DESCRIPCION: MotoParkingCost - Calcula el costo total del parking de una motocicleta. 
* | ESTUDIANTE: Andrés david Muñoz Cerón - Diego Collazos Perafan 
* | FECHA: 17/11/2021
* +--------------------------------------------------------------------------------------+
*/

/*Librerias de tipo TIME*/
import java.time.Duration;
import java.time.LocalDateTime;

/*Class*/
public class MotoParkingCost implements IParkingCost{
    
    /*función que retorna el costo total de parqueo*/
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        Duration d1 = Duration.between(input, output); //Instancia de Duration 
        double horas = d1.toMinutes()/ 60.00; // Calculo de horas
        long cost = 0; //Total 
        
        //calculo de tarifa 
        if (horas < 1) {
            cost = 1000;
        } else if (horas == 1) {  
            cost = 2000;
        } else {
            double costo = 2000 + (horas - 1) * 1000; //Variable aux 
            cost = (long) Math.ceil(costo / 100) * 100; 
        }
        return cost; 
    }
}
