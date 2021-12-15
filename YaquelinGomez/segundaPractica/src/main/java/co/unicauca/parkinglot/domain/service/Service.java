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
 * Class Service
 * @author YAQUE
 */
public class Service {
    private IVehicleRepository repository;

    /**
     * Constructor por defecto
     * Inyección de dependencias
     * @param repository una clase hija de IVehicleRepository
     */
    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }

    /**
     * Maneja una lógica de negocio simple para calcular el valor a pagar en el parqueadero
     * @param vehicle Datos vehiculo
     * @param input Fecha y hora entrada
     * @param output Fecha y hora salida 
     * @return Valor a pagar en el parqueadero 
     */
    public long calculateParkingCost(Vehicle vehicle, LocalDateTime input , LocalDateTime output) {

        //Validate vehicle.
        if (vehicle == null) {
            return -1;
        }
        // La fábrica devuelve una instancia de la jerarquia IDelivery
        IParkingCost parking = ParkingCostFactory.getInstance().getParking(vehicle.getType());
        long result = parking.calculateCost(vehicle, input, output);

        return result;
    }

    /**
     * Graba el vehiculo en la base de datos
     * @param newVehicle Vehiculo a ser grabado
     * @return true si lo graba en la bd, false en caso contrario
     */
    public boolean saveVehicle(Vehicle newVehicle) {

        //Validate product
        if (newVehicle == null || newVehicle.getPlate().isEmpty()) {
            return false;
        }

        repository.save(newVehicle);
        return true;

    }

    /**
     * Listar vehiculos
     * @return Lista de vehiculos
     */
    public List<Vehicle> listVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = repository.list();

        return vehicles;
    }
}
