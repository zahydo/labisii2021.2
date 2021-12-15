/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.parkinglot.acces;

import co.unicauca.parkinglot.domain.Vehicle;
import java.util.ArrayList;


/**
 *
 * @author David E
 */
public interface IVehicleRepository {
    public boolean save(co.unicauca.parkinglot.domain.Vehicle newVehiculo);
    public ArrayList<Vehicle> list();
}
