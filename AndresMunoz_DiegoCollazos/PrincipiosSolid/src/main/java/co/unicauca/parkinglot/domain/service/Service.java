package co.unicauca.parkinglot.domain.service;
/**
* +--------------------------------------------------------------------------------------+
* | DESCRIPCION: Service - clase de servicios. 
* | ESTUDIANTE: Andrés david Muñoz Cerón - Diego Collazos Perafan 
* | FECHA: 17/11/2021
* +--------------------------------------------------------------------------------------+
*/

/* Librerias */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*Paquetes */
import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.Vehicle;

/*class */
public class Service {
    IVehicleRepository repository; //Instancia de IVehicleRepository
    
    /*Constructor*/
    public Service (IVehicleRepository repository) {
        this.repository = repository;
    }

    
    /*Retorna el costo total de parqueo*/ 
    public long calculateParkingCost (Vehicle vehicle, LocalDateTime input, LocalDateTime output) {
        //Validaciones
        if (vehicle == null || input == null || output == null){
            return -1;  
        }
        IParkingCost park = ParkingCostFactory.getInstance().getParkingCost(vehicle.getType()); //Instancia un objeto del tipo IParkingCost a través de ParkinCostFactory  
        return park.calculateCost(vehicle, input, output); 
    }

    /*Envía un nuevo elemento de tipo Vehicle a repository, para ser procesado y almacenado*/
    public boolean saveVehicle (Vehicle newVehicle) {
        if (newVehicle == null || newVehicle.getPlate() == null  || newVehicle.getType() == null) {
            return false;
        }
        repository.save(newVehicle);
        return true;
    }

    /*Obtiene de repository un listado de los vehiculos almacenados*/ 
    public List<Vehicle> listVehicles() {
        List<Vehicle> vehicles = new ArrayList<>(); //List de Vehicles
        vehicles = repository.list();

        return vehicles;
    }
}