package co.unicauca.domain.service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import co.unicauca.access.IVehicleRepository;
import co.unicauca.domain.IParkingCost;
import co.unicauca.domain.ParkingCostFactory;
import co.unicauca.domain.Vehicle;

public class Service {

    private IVehicleRepository repository;

    public Service(){

    }

    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }


    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output){
        IParkingCost delivery = ParkingCostFactory.getInstance().getType(veh.getType());
        long result = delivery.calculateCost(veh, input, output);
        return result;
    }

    public void saveVehicle(Vehicle newVehicle){
        repository.save(newVehicle);
    }

    public List<Vehicle> listVehicles(){
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles = repository.list();

        return vehicles;

    }
}
