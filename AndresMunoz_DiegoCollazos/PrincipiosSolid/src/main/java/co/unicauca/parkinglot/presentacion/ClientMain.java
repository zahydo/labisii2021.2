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
        Vehicle veh = new Vehicle("FTK-123", TypeEnum.MOTO); //Vehicle
        LocalDateTime input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0); //Dates 
        LocalDateTime output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 19, 30);
        IVehicleRepository repo = RepositoryFactory.getInstance().getRepositoryType("default"); //Inicialización del repositorio 
        Service service = new Service(repo); //Inyección de dependencias //Instancia de Service
        long result = service.calculateParkingCost(veh, input, output); //Resultado 
        System.out.println("Valor a pagar por la moto: " + result);
        service.saveVehicle(veh); //almacenado de una instancia de Vehicle
        veh = new Vehicle("JNK-124", TypeEnum.CAR);
        service.saveVehicle(veh);
        List<Vehicle> list = service.listVehicles(); //Listado de los datos almacenados 
        list.forEach(vehicle -> {
            System.out.println(vehicle.toString());
        });
    }
}
