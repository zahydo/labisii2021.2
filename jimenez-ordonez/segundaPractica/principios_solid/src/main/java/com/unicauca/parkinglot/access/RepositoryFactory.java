package com.unicauca.parkinglot.access;

public class RepositoryFactory {
    
    private static RepositoryFactory instance;
    private IVehicleRepository repository;

    private RepositoryFactory(){
        this.repository = new VehicleRepository();
    }

    
    /** 
     * @return RepositoryFactory
     */
    public static RepositoryFactory getInstance(){
        if (RepositoryFactory.instance == null){
            RepositoryFactory.instance = new RepositoryFactory();
        }
        return RepositoryFactory.instance;
    }

    
    /** 
     * @param type
     * @return IVehicleRepository
     */
    public IVehicleRepository getRepository(String type) {
        return this.repository;
    }
}
