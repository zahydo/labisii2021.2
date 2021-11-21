/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author Antonio E
 */
public class Service {
    
    
    private IVehicleRepository repository;

    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }
    
    public long calculateParkingCost(Vehicle vehicle, LocalDateTime input,LocalDateTime output) {
        
        if (vehicle == null) {
            return 0;
        }
        
        IParkingCost cost = ParkingCostFactory.getInstance().getRepository(vehicle.getType());
        return cost.calculateCost(vehicle, input, output);
    }
    
    public boolean saveVehicle(Vehicle newVehicle){
        if (!newVehicle.getPlate().isEmpty()) 
            return repository.save(newVehicle);       
        return false;
    }
    
    public List<Vehicle> listVehicles(){
        return repository.list();
    }  
}
