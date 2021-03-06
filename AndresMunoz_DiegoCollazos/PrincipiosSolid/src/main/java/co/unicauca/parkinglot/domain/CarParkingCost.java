package co.unicauca.parkinglot.domain;
/**
* +--------------------------------------------------------------------------------------+
* | DESCRIPCION: CarkparkingCost - calcula la tarifa de parqueo de un carro
* | ESTUDIANTE: Andrés david Muñoz Cerón - Diego Collazos Perafan 
* | FECHA: 17/11/2021
* +--------------------------------------------------------------------------------------+
*/

/*librerias asociadas a el tipo LocalDateTime, Duration*/
import java.time.Duration;
import java.time.LocalDateTime;

/*Class*/ 
public class CarParkingCost implements IParkingCost {
    /*default constructor */
    public CarParkingCost() {
    }
    /*funcion que retorna la tarifa correspondiente*/
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        double tarifa = 4000; // tarifa base 
        Duration d1 = Duration.between(input, output);  //Instancia de Duration 
        double horas = d1.toMinutes()/60.00; //Calculo de horas 

        double resultado = tarifa; //Variable para el total 

        if(horas > 1){
            resultado += (tarifa/2)*(horas-1);
            resultado = Math.ceil(resultado/100) * 100;
        }else if(horas < 1){
            resultado /= 2;
        }

        return (long)resultado;
    }
}
