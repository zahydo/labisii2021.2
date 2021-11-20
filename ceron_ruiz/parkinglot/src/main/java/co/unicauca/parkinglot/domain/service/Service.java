/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.domain.service;


import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.access.IVehicleRepository;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Daniel Cerón
 */
public class Service {

    private final IVehicleRepository repository;

    /**
     * @param repository
     */
    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }

    public long calculateParkingCost(Vehicle veh, LocalDateTime initialTime, LocalDateTime finalTime) {
        try {
            IParkingCost delivery = ParkingCostFactory.getInstance().getType(veh.getType());
            long result = delivery.calculateCost(veh, initialTime, finalTime);
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