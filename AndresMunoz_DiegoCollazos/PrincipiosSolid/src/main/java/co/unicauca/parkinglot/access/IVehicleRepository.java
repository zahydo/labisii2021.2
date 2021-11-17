package co.unicauca.parkinglot.access;
/**
* +--------------------------------------------------------------------------------------+
* | DESCRIPCION: interfaz encargada de instanciar los repositorios
* | ESTUDIANTE: Andrés david Muñoz Cerón - Diego Collazos Perafan 
* | FECHA: 17/11/2021
* +--------------------------------------------------------------------------------------+
*/


import co.unicauca.parkinglot.domain.Vehicle; //Paquete del dominio del tipo Vehicle
import java.util.List; // Librería de java para uso de listas 

/*Interfaz */
public interface IVehicleRepository {
    boolean save(Vehicle newVehiculo);
    List<Vehicle> list();
}