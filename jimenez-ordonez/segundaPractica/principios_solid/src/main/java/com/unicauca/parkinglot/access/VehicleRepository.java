package com.unicauca.parkinglot.access;

import java.sql.Connection;
import java.util.List;
import com.unicauca.parkinglot.domain.Vehicle;

public class VehicleRepository implements IVehicleRepository {
    
    private Connection conn;

    public VehicleRepository() {

    }

    @Override
    public boolean save(Vehicle newVehiculo) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Vehicle> list() {
        // TODO Auto-generated method stub
        return null;
    }

    private void initDatabase() {

    }

    public void connect() {

    }

    public void disconnect(){

    }
}
