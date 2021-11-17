/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain.service;

import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yahir Garcés
 */
public class Service {
    private IVehicleRepository repository = new IVehicleRepository() {
        @Override
        public List<Vehicle> list() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean save(Vehicle newVehicle) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    } ;


    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }

    
    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output){
        ParkingCostFactory pcf = new ParkingCostFactory();
        long result;
        result = pcf.getParkingCost(veh.getType()).calculateCost(veh, input, output);
        
        float r = (float)result/100;
        r = Math.round(r);
        r=(r)*100;
        result = (new Double(r)).longValue();
        return result;
        
    }      

    public boolean saveVehicle(Vehicle veh) {
        if (veh == null || veh.getPlate().isEmpty() ) {
            return false;
        }
        repository.save(veh);
        return true;
    }

    public List<Vehicle> listVehicles() {
        List<Vehicle> vehiculos = new ArrayList<>();
        vehiculos = repository.list();;

        return vehiculos;
    }
    
    public boolean promocion (int number){
        int random = (int) (Math.random()*1000+1);
        if(number == random){
            System.out.println("Has tenido suerte, tu costo de parqueadero es 0");
            return true;
        }else {
            System.out.println("No hay suerte esta vez, debes cancelar el valor");
            return false;
        }
    }
}
