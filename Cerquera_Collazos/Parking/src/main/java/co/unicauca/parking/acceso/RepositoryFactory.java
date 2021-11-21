/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parking.acceso;


import java.util.List;

/**
 *
 * @author cerqu
 */
public class RepositoryFactory {
    
    private RepositoryFactory instance;

    public RepositoryFactory() {
    }
    
    public RepositoryFactory(RepositoryFactory instance) {
        this.instance = instance;
    }

    public RepositoryFactory getInstance() {
        return instance;
    }
    
    public IVehicleRepository getRepository(String type) {
        IVehicleRepository iVehicleRepository = null;
        switch (type) {
            case "default":
                iVehicleRepository = new VehicleRepository();
        }
        return iVehicleRepository;
    }
}
