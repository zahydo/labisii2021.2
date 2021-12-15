/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain.service;
import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;
import java.util.List;
/**
 *
 * @author Kevin Daryany Morales
 */
public class Service {
    IVehicleRepository repository;
    
    /**
     * 
     * @param repository 
     */
    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }
    
    
    public long calculateParkingCost(Vehicle veh,LocalDateTime input,LocalDateTime output){
        if (veh==null) 
            return -1;
        // La fábrica devuelve una instancia de la jerarquia IParkingCost  
        IParkingCost cost = ParkingCostFactory.getInstance().getRepository(veh.getType());
        return cost.calculateCost(veh, input, output);
    }
    /**
     * Guarda un vehivulo
     * @param newVehiculo
     * @return repoitorio vehiculos
     */
    public boolean saveVehicle(Vehicle newVehiculo){
        if (!newVehiculo.getPlate().isEmpty()) 
            return repository.save(newVehiculo);       
        return false;
    }
    /**
     * Lista vehiculo
     * @return repositorio vehiculo
     */
    public List<Vehicle> listVehicles(){
        return repository.list();
    }  
}
