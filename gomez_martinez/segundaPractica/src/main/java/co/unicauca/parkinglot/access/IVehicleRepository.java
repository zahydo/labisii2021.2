package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import java.util.List;


/**
 * @author angiecgomez
 * @author mafemartinez
 */
public interface IVehicleRepository {
    
    /**
     * Abstract methods that must be implemented by the inheriting classes
     */
    
    
    /**
     * Save a new Vehicle 
     * @param newVehicle
     * @return 
     */
    boolean save(Vehicle newVehicle);
    
    /**
     * Create a vehicles' list 
     * @return vehicles' list
     */
    List<Vehicle> list();
}
