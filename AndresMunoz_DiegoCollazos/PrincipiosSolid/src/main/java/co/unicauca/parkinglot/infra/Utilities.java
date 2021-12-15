
package co.unicauca.parkinglot.infra;
/**
* +--------------------------------------------------------------------------------------+
* | DESCRIPCION: Estable una instancia de la interfaz IParkingCost con la que se determina el 
* | tipo de calculo de tarifa que se va a hacer.
* | ESTUDIANTE: Andrés david Muñoz Cerón - Diego Collazos Perafan 
* | FECHA: 17/11/2021
* +--------------------------------------------------------------------------------------+
*/
/*Librerias y paquetes*/
import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;

/*Class*/
public class Utilities {
    /*constructor*/
    public Utilities(){}; 
    
    /*Metodo que establece de que tipo será la instancia IParkingCost*/
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output){
        if (veh == null || input == null || output == null){
            return -1;  
        }
        //Instancia un hijo de IParkingCost según el tipo de vehiculo, y procede a calcular el costo de parqueo
        IParkingCost park = ParkingCostFactory.getInstance().getParkingCost(veh.getType()); 
        return park.calculateCost(veh, input, output); 
    }
    
}
