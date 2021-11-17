package com.unicauca.parkinglot.access;

public class RepositoryFactory {
    private static RepositoryFactory instance;
    private IVehicleRepository repository;

    private RepositoryFactory(){
        this.repository = new VehicleRepository();
    }

    public static RepositoryFactory getInstance(){
        if (RepositoryFactory.instance == null){
            RepositoryFactory.instance = new RepositoryFactory();
        }
        return instance;
    }

    public IVehicleRepository getRepository(String type) {
        return this.repository;
    }
}
