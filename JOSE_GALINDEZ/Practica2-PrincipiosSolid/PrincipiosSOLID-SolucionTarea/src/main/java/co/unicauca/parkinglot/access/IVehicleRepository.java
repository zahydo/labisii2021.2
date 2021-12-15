/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import java.util.List;

/**
 * Interfaz para el repositorio de vehiculos
 * @author Jose_R
 */
public interface IVehicleRepository {
    
    //Atributo que permite listar los vehiculos de la DB
    List<Vehicle> list();
    /**
     * Metodo abstracto para guardar un vehiculo en BD
     * @param newVehicle Vehiculo a guardar
     * @return 
     */
    boolean save(Vehicle newVehicle);

    
}
