package com.unicauca.parkinglot.domain.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.unicauca.parkinglot.access.IVehicleRepository;
import com.unicauca.parkinglot.domain.ParkingCostFactory;
import com.unicauca.parkinglot.domain.Vehicle;

public class Service {

    private IVehicleRepository repository;

    public Service(IVehicleRepository repo) {
        this.repository = repo;
    }

    
    /** 
     * Calcula el costo del servicio de parque dependiendo del tipo de vehiculo,
     *  la fecha de inicio y final del servicio
     * @param veh
     * @param input
     * @param output
     * @return long
     */
    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        ParkingCostFactory factory = ParkingCostFactory.getInstance();
        long result;
        result = factory.getParkingCost(veh.getType()).calculateCost(veh, input, output);
        return result;
    }

    
    /** 
     * Almacena el vehiculo recibido en la base de datos
     * @param veh
     */
    public void saveVehicle(Vehicle veh){
        repository.save(veh);
    }

    
    /** 
     * Retorna la lista de vehiculos almacenados en la base de datos
     * @return List<Vehicle>
     */
    public List<Vehicle> listVehicles() {
        return (repository.list() == null)?new ArrayList<Vehicle>():repository.list();
    }
    
}
