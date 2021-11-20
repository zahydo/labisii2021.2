/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.domain.service;

/**
 *
 * @author jnino_jabella.
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.access.IVehicleRepository;

public class Service {

    IVehicleRepository repository;

    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }

    public long calculateParkingCost(Vehicle vehicle, LocalDateTime input, LocalDateTime output) {
        return ParkingCostFactory.getInstance().getParkingCost(vehicle.getTipo()).calculateCost(vehicle, input, output);
    }

    public boolean saveVehicle(Vehicle Nuevo_Vehicle) {
        if (Nuevo_Vehicle == null || Nuevo_Vehicle.getPlaca() == null || Nuevo_Vehicle.getTipo() == null) {
            return false;
        }
        repository.save(Nuevo_Vehicle);
        return true;
    }

    public List<Vehicle> listVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = repository.listVehiculo();

        return vehicles;
    }
}
