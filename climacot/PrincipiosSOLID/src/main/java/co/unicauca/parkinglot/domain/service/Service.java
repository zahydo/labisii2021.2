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

public class Service {

    private IVehicleRepository repository;

    /**
     * Constructor parametrizado
     *
     * @param repository
     */
    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }

    /**
     * Calcula el costo por minuto para una instancia de iparkingcost
     *
     * @param veh
     * @param input
     * @param output
     * @return result, costo de iparkingcost
     */
    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        if (veh == null) {
            return -1;
        }
        IParkingCost delivery = ParkingCostFactory.getInstance().getType(veh.getType());
        long result = delivery.calculateCost(veh, input, output);
        return result;
    }

    /**
     * Guarda en el repositorio un nuevo vehiculo
     *
     * @param newVehiculo
     * @return boolean
     */
    public boolean saveVehicle(Vehicle newVehiculo) {
        if (newVehiculo == null) {
            return false;
        }
        repository.save(newVehiculo);
        return true;
    }

    /**
     * Lista los vehiculos guardados en el repositorio
     *
     * @return Lista de vehiculos
     */
    public List<Vehicle> listVehicles() {
        List<Vehicle> vehiculos = new ArrayList<>();
        vehiculos = repository.list();
        return vehiculos;
    }
}
