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

    
    /** 
     * Calculates Parking Rate given a Vehicle, entry time and departure time
     * @param veh Vehicle 
     * @param input Entry Time and Date
     * @param output Departure Time and Date
     * @return long Parking Rate
     */
    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output){
        IParkingCost delivery = ParkingCostFactory.getInstance().getType(veh.getType());
        long result = delivery.calculateCost(veh, input, output);
        return result;
    }

    
    /** 
     * Pushes a New Vehicle to DB
     * @param newVehicle 
     */
    public void saveVehicle(Vehicle newVehicle){
        repository.save(newVehicle);
    }

    
    /** Returns the list with all the vehicles in DB
     * @return List<Vehicle>
     */
    public List<Vehicle> listVehicles(){
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles = repository.list();

        return vehicles;

    }
    
}
