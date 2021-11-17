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
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.infra.Utilities;

/*class */
public class Service {
    IVehicleRepository repository;
    
    /*Constructor*/
    public Service (IVehicleRepository repository) {
        this.repository = repository;
    }

    /*Llama a la función calculateParkingCost de la clase utilidades - retorna el valor total (long)*/
    public long calculateParkingCost (Vehicle vehicle, LocalDateTime input, LocalDateTime output) {
        Utilities uti = new Utilities();
        return uti.calculateCost(vehicle, input, output); 
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
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = repository.list();

        return vehicles;
    }
}