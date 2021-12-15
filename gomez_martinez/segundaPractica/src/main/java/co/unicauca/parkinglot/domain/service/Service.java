package co.unicauca.parkinglot.domain.service;

import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author angiecgomez
 * @author mafemartinez
 */
public class Service {
    
    /**
     * Attributes
     */
    
    public IVehicleRepository repository;

    /**
     * Constructor with parameters
     * @param repository 
     */
    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }
   
    /**
     * Methods
     */
    
    /**
     * Calculate the total parking cost of a vehicle  
     * @param veh
     * @param input
     * @param output
     * @return rate, total parking cost
     */
    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output){
        
        IParkingCost delivery = ParkingCostFactory.getInstance().getParkingCost(veh.getType());
        long rate = delivery.calculateCost(veh, input, output);
        return rate;
        
    }
    
    /**
     * Save a new Vehicle in repository
     * @param newVehicle
     * @return boolean 
     */
    public boolean saveVehicle(Vehicle newVehicle){
        if (newVehicle == null){
            return false;
        }
        repository.save(newVehicle);
        return true;   
    }
    
    /**
     * Retrieves in a list all vehicles stored in the repository
     * @return vehicles' list
     */
    public List<Vehicle> listVehicles(){
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = repository.list();
        return vehicles;
    }
    
    
    
    
    
    
}
