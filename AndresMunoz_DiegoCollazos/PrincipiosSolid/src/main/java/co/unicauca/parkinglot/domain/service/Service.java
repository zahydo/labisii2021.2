package co.unicauca.parkinglot.domain.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.domain.CarParkingCost;
import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.MotoParkingCost;
import co.unicauca.parkinglot.domain.TruckParkingCost;
import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.infra.Utilities;

public class Service {
    IVehicleRepository repository;

    public Service (IVehicleRepository repository) {
        this.repository = repository;
    }

    public long calculateParkingCost (Vehicle vehicle, LocalDateTime input, LocalDateTime output) {
        Utilities uti = new Utilities();
        return uti.calculateCost(vehicle, input, output); 
    }

    public boolean saveVehicle (Vehicle newVehicle) {
        if (newVehicle == null || newVehicle.getPlate() == null  || newVehicle.getType() == null) {
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