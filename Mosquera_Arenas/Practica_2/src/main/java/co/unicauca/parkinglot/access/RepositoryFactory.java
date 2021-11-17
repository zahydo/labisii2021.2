/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.access;

/**
 * Fabrica de instacias de repositorios
 * @fecha 2021/11/17
 * @author Miguel Mosquera, Sebastian Arenas
 */
public class RepositoryFactory {

    private static RepositoryFactory instance; //Unica instancia de RepositoryFactory
   
    /** 
     * Constructor por defecto 
     */
    private RepositoryFactory() {
    }
    
    /** 
     * Retorna una instancia de esta clase 
     * @return RepositoryFactory instance
     */
    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }
    
    /** 
     * Retorna una instancia de repositorio
     * @return IVehicleRepository result VehicleRepository
     */
    public IVehicleRepository getRepository(String type) {
        IVehicleRepository result = null;

        switch (type) {
            case "default":
                result = new VehicleRepository();
                break;
        }
        return result;
    }
    
}
