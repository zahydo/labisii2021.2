/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.parking.acceso;

import co.unicauca.parking.negocio.Vehicle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cerqu
 */
public interface IVehicleRepository {
    public List<Vehicle> list();
    public boolean save(Vehicle vehiculo);
}
