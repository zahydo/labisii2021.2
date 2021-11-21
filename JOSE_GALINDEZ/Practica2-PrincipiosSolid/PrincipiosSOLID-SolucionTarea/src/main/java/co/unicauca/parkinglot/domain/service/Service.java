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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose R
 */
public class Service {

    private IVehicleRepository repository;

    /**
     * Inyección de dependencias en el constructor. Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     * @param repository una clase hija de IProductRepository
     */
    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }

    public long calculateParkingCost(Vehicle vehicle, LocalDateTime input, LocalDateTime output) {

        //Validate vehicle.
        if (vehicle == null) {
            return -1;
        }
        // La fábrica devuelve una instancia de la jerarquia IDelivery
        IParkingCost parking = ParkingCostFactory.getInstance().getParking(vehicle.getType());
        long result = parking.calculateCost(vehicle, input, output);

        return result;
    }

    public boolean saveVehicle(Vehicle newVehicle) {

        //Validate product
        if (newVehicle == null || newVehicle.getPlate().isEmpty()) {
            return false;
        }

        repository.save(newVehicle);
        return true;

    }

    public List<Vehicle> listVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = repository.list();

        return vehicles;
    }
}
