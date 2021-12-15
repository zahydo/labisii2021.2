package com.unicauca.parkinglot.access;

public class RepositoryFactory {
    
    private static RepositoryFactory instance;
    private IVehicleRepository repository;

    private RepositoryFactory(){
        this.repository = new VehicleRepository();
    }

    /** 
     * Este metodo retorna la instancia de esta clase respetando el patron de
     * diseño Singleton
     * @return RepositoryFactory
     */
    public static RepositoryFactory getInstance(){
        if (RepositoryFactory.instance == null){
            RepositoryFactory.instance = new RepositoryFactory();
        }
        return RepositoryFactory.instance;
    }

    
    /** 
     * Este metodo retorna los repositorios dependiendod del tipo, por ahora
     * VehicleRepository es la unica existente
     * @param type
     * @return IVehicleRepository
     */
    public IVehicleRepository getRepository(String type) {
        return this.repository;
    }
}
