package co.unicauca.access;

import java.util.List;

import co.unicauca.domain.Vehicle;

public interface IVechicleRepository {
    
    public boolean save(Vehicle newVehiculo);

    public List<Vehicle> list();
}
