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
    
    private static RepositoryFactory instance;

    public RepositoryFactory() {
    }
    
    public RepositoryFactory(RepositoryFactory instance) {
        this.instance = instance;
    }

    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }
    
    public IVehicleRepository getRepository(String type) {
        IVehicleRepository iVehicleRepository = null;
        switch (type) {
            case "default":
                iVehicleRepository = new VehicleRepository();
                break;
        }
        return iVehicleRepository;
    }
}
