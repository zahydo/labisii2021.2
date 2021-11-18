/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain.service;

import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import com.unicauca.parkinglot.access.IVehicleRepository;
import com.unicauca.parkinglot.access.VehicleRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 57322
 */
public class Service {

    //Atributos
    private VehicleRepository repository;

    public Service(IVehicleRepository repo) {

        repository = new VehicleRepository();

    }

    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        //Fabrica de ParkingCost
        IParkingCost myCost = ParkingCostFactory.getInstance().getParkingCost(veh.getType());
        return myCost.calculateCost(veh, input, output);

    }

    public boolean saveVehicle(Vehicle veh) {

        //Validate product
        if (veh == null || veh.getPlate().equals("") || veh.getPlate().isEmpty()) {
            return false;
        }

        repository.save(veh);
        return true;
    }

    public ArrayList<Vehicle> listVehicles() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles = repository.list();
        return vehicles;
    }

}
