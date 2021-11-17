package co.unicauca.parkinglot.domain.service;

import java.util.ArrayList;
import java.util.List;

import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.domain.Vehicle;

public class Service {
    IVehicleRepository repository;

    public Service (IVehicleRepository repository) {
        this.repository = repository;
    }

    public double calculateParkingCost (Vehicle vehicle) {
        if (vehicle == null) {
            return 0;
        }
        return vehicle.calculateCost();
    }

    public boolean saveVehicle (Vehicle newVehicle) {
        if (newVehicle == null || newVehicle.getPlate().isBlank() || newVehicle.getType().isBlank()) {
            return false;
        }
        repository.save(newVehicle);
        return true;
    }

    public List<Vehicle> listVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = repository.list();

        return vehicles;
    }
}