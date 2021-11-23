/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parking.negocio.servicio;

import co.unicauca.parking.acceso.IVehicleRepository;
import co.unicauca.parking.negocio.IParkingCost;
import co.unicauca.parking.negocio.ParkingCostFactory;
import co.unicauca.parking.negocio.Vehicle;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author cerqu
 */
public class Service {
    private IVehicleRepository repository;
    private IParkingCost parkingCost;

    public Service() {
        repository = null;
    }

    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }
    
    public long calculateParkingCost(Vehicle vehiculo, LocalDateTime input, LocalDateTime output) {
        long costo = 0;
        if(vehiculo == null || input == null || output == null) {
            return -1;
        }        
        parkingCost = ParkingCostFactory.getInstance().getParkingCost(vehiculo.getTipoV());
        costo = parkingCost.calculatecost(vehiculo, output, output);
        return costo;
    }
    
    public boolean saveVehicle(Vehicle vehiculo) {
        List<Vehicle> listaVehiculos;
        if(vehiculo == null) {
            return false;
        } 
        for(int i = 0; i <= repository.list().size(); i++) {
            if (repository.list().get(i).equals(vehiculo)) {
                return false;
            }
        }    
        repository.save(vehiculo);
        return true;
    }
    
    public List<Vehicle> listVehicles() {
        List<Vehicle> listaVehiculos = repository.list();
        return listaVehiculos;
    }
}
