package co.unicauca.parkinglot.domain;
/**
* +--------------------------------------------------------------------------------------+
* | DESCRIPCION: interfaz encargada de instanciar el método calculatecost. 
* | ESTUDIANTE: Andrés david Muñoz Cerón - Diego Collazos Perafan 
* | FECHA: 17/11/2021
* +--------------------------------------------------------------------------------------+
*/
import java.time.LocalDateTime;
/*Interface*/
public interface IParkingCost {
    /*Método para la sobreescritura - calcula el costo de la tarifa según sea*/
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output); 
}
