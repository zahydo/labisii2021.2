package com.unicauca.parkinglot.domain.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.unicauca.parkinglot.access.IVehicleRepository;
import com.unicauca.parkinglot.domain.ParkingCostFactory;
import com.unicauca.parkinglot.domain.Vehicle;

public class Service {

    private IVehicleRepository repository;

    public Service(IVehicleRepository repo) {
        this.repository = repo;
    }

    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        ParkingCostFactory factory = new ParkingCostFactory();
        long result;
        result = factory.getParkingCost(veh.getType()).calculateCost(veh, input, output);
        return result;
    }

    public void saveVehicle(Vehicle veh){
        repository.save(veh);
    }

    public List<Vehicle> listVehicles() {
        return (repository.list() == null)?new ArrayList<Vehicle>():repository.list();
    }
    
}
