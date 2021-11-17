/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.acces;

/**
 *
 * @author David E
 */
public class RepositoryFactory{
    
    private static RepositoryFactory instance;
    
    private RepositoryFactory(){
        
    }

    /**
     * @return the instance
     */
    public static RepositoryFactory getInstance() {
        if(instance == null){
            instance = new RepositoryFactory();
        }
        return instance;
    }
    
    /**
     * @return el tipo de vehiculo
     */
    public IVehicleRepository getRepository(String Type){
        IVehicleRepository result = null;
        switch(Type){
            case "default":
                result = new VehicleRepository();
                break;
        }
        return result;
                
    }
    
    
    
}
