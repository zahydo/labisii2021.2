package co.unicauca.parkinglot.presentacion;
/**
* +--------------------------------------------------------------------------------------+
* | DESCRIPCION: Main
* | ESTUDIANTE: Andrés david Muñoz Cerón - Diego Collazos Perafan 
* | FECHA: 17/11/2021
* +--------------------------------------------------------------------------------------+
*/

/*Librerias */
import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.access.RepositoryFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.service.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

/*Class*/
public class ClientMain {
    /*Funcion principal */
    public static void main(String[] args) {
        Vehicle veh = new Vehicle("FTK-123", TypeEnum.MOTO);//Objeto vehiculo para prueba en clase main
        LocalDateTime input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0);//Fecha entrada del vehiculo para prueba
        LocalDateTime output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 19, 30);//Fecha salida del vehiculo para prueba
        IVehicleRepository repo = RepositoryFactory.getInstance().getRepositoryType("default");//Instancia los datos de la base de datos
        Service service = new Service(repo); //Inyección de dependencias
        long result = service.calculateParkingCost(veh, input, output);//Llamado al método que calcula el coste del parqueadero según el tipo del vehiculo
        System.out.println("Valor a pagar por la moto: " + result);
        service.saveVehicle(veh);//Inserta los datos del vehiculo en la base de datos
        veh = new Vehicle("JNK-124", TypeEnum.CAR);
        service.saveVehicle(veh);//Inserta los datos del vehiculo en la base de datos
        List<Vehicle> list = service.listVehicles();//Instancia la lista de vehiculos en la base de datos
        list.forEach(vehicle -> {
            System.out.println(vehicle.toString());
        });
    }
}
