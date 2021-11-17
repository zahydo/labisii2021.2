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
 * @author Andres Garcia
 * @author Felipe Garcia
 */
public class Service {

    private final IVehicleRepository repository;

    /**
     * Constructor parametrizado
     *
     * @param repository
     */
    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }

    /**
     * Calcula el costo para una instancia de Iparkingcost
     *
     * @param veh
     * @param input
     * @param output
     * @return result, costo de Iparkingcost
     */
    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        try {
            IParkingCost delivery = ParkingCostFactory.getInstance().getType(veh.getType());
            long result = delivery.calculateCost(veh, input, output);
            return result;
        } catch (NullPointerException e) {
            return -1;
        }
    }

    /**
     * Guarda en RepositoryVehicle un nuevo vehiculo
     *
     * @param newVehiculo
     * @return boolean
     */
    public boolean saveVehicle(Vehicle newVehiculo) {
        try {
            repository.save(newVehiculo);
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    /**
     * Lista los vehiculos guardados en el repositorio
     *
     * @return Lista de vehiculos
     */
    public List<Vehicle> listVehicles() {
        return repository.list();
    }
}
