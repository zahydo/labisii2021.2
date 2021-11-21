/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.domain.service;

import co.unicauca.parkinglot.acces.IVehicleRepository;
import co.unicauca.parkinglot.acces.RepositoryFactory;
import co.unicauca.parkinglot.domain.CarParkingCost;
import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.MotoParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.TruckParkingCost;
import co.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 *
 * @author David E
 */
public class Service {
    
    private co.unicauca.parkinglot.acces.IVehicleRepository repository;
    
    public Service(){
        
    }
    
    public Service(IVehicleRepository Ivr){
        this.repository = Ivr;
    }
    
    public void saveVehicle(Vehicle vehicle){
        if(vehicle != null){
            repository.save(vehicle);
        }
    }
    
    public ArrayList<Vehicle> listVehicles(){
        return repository.list();
    }
    
    /**
     * hace el llamdo para calcular el costo del parking
     * 
     */
    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        
        long resultado;
        
        if(veh == null){
            return -1;
        }
        
        IParkingCost aux = ParkingCostFactory.getInstance().getParkingCost(veh.getType());
        
        resultado = aux.calculateCost(veh, input, output);
        
        return resultado;
    }
    
}
