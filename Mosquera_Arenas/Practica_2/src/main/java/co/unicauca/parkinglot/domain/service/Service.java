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
import java.util.ArrayList;

/**
 * Administra todo el proceso de gestion de Vehiculos y de parking
 * @fecha 2021/11/17
 * @author Miguel Mosquera, Sebastian Arenas
 */
public class Service {
    private IVehicleRepository repository;  //Repositorio de la base de datos
    
    /** 
     * Constructor
     * @param un repositorio de tipo IVehicleRepository
     */
    public Service(IVehicleRepository repo) {
        repository = repo;
    }
    
    /** 
     * Calcula y retorna el valor del parking
     * @param Vehiculo, fecha de ingreso, fecha de salida
     * @return costo de parking
     */
    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output){ 
        if (veh == null) {
            return -1;
        }
        
        
        IParkingCost parking_Service = ParkingCostFactory.getInstance().getParkingCost(veh.getType());
        
        long precio = parking_Service.calculateCost(veh, input, output);
        
        return precio;
    }
    
    /** 
     * Almacena un vehiculo en la base de datos
     * @param un vehiculo
     * @return True si se almaceno correctamente
     */
    public boolean saveVehicle(Vehicle veh){
        //Validate product
        if (veh == null || veh.getPlate() == null || veh.getType() == null) {
            return false;
        }
        
        repository.save(veh);
        return true;
    }
    
    /** 
     * Retorna la lista de vehiculos
     * @return Lista de vehiculos almacenados en la base de datos
     */
    public ArrayList<Vehicle> listVehicles(){
        return repository.list(); 
    }
    
}
