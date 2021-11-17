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
<<<<<<< HEAD

        double resultado = tarifa;

=======

        double resultado = tarifa;

>>>>>>> 4c02db107458db84e962543026ad291214c63fde
        if(horas > 1){
            resultado += (tarifa/2)*(horas-1);
            resultado = Math.ceil(resultado/1000) * 1000;
        }else if(horas < 1){
            resultado /= 2;
        }

        return (long)resultado;
    }
}
