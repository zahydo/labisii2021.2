package co.unicauca.parkinglot.domain.service;


import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.access.IVehicleRepository;
import java.time.LocalDateTime;
import java.util.List;

public class Service {

    private final IVehicleRepository repository;

    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }

    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        try {
            IParkingCost delivery = ParkingCostFactory.getInstance().getType(veh.getType());
            long result = delivery.calculateCost(veh, input, output);
            return result;
        } catch (NullPointerException e) {
            return -1;
        }
    }
    
    public boolean saveVehicle(Vehicle newVehiculo) {
        try {
            repository.save(newVehiculo);
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public List<Vehicle> listVehicles() {
        return repository.list();
    }
}