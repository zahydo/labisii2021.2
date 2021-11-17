package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class CarParkingCost implements IParkingCost {
    public CarParkingCost() {
    }
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        double tarifa = 4000;
        Duration d1 = Duration.between(input, output); 
        double horas = d1.toMinutes()/60.00;
        
        double resultado = tarifa;
        
        if(horas > 1){
            resultado += (tarifa/2)*(horas-1);
            resultado = Math.ceil(resultado/100) * 100;
        }else if(horas < 1){
            resultado /= 2;
        }

        return (long)resultado;
    }
}
