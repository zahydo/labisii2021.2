/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import java.util.List;

/**
 *
 * @author Andres Garcia
 * @author Felipe Garcia
 */
public interface IVehicleRepository {

    public boolean save(Vehicle veh);

    List<Vehicle> list();
}
