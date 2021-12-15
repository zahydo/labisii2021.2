package com.unicauca.parkinglot.access;

import java.util.List;
import com.unicauca.parkinglot.domain.Vehicle;

public interface IVehicleRepository {

    public boolean save(Vehicle newVehiculo);
    public List<Vehicle> list();
    
}
