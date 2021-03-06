/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import java.util.List;

/**
 * Interfaz que permite guardar los datos de los vehiculos que ingresan al parqueadero
 * @author YAQUE
 */
public interface IVehicleRepository {
    boolean save(Vehicle newVehicle);

    List<Vehicle> list();
}
