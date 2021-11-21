/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parking.acceso;

import co.unicauca.parking.negocio.Vehicle;
import java.util.List;

/**
 *
 * @author Sebastián Collazos - Eliana Cerquera
 */
public class VehicleRepository implements IVehicleRepository{
    
    //
    //Atributos
    //
    private List<Vehicle> vehiculos;    

    public VehicleRepository() {
    }
    
    @Override
    public List<Vehicle> list() {
        return vehiculos;
    }

    @Override
    public boolean save(Vehicle vehiculo) {
        
        if(!vehiculos.contains(vehiculo)) {
            vehiculos.add(vehiculo);
            return true;
        }
        return false;
    }
    
}
