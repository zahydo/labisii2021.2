package com.unicauca.parkinglot.access;

public class RepositoryFactory {
    
    private RepositoryFactory instance;

    private RepositoryFactory(){

    }

    public RepositoryFactory getInstance() {
        return instance;
    }

    public IVehicleRepository getRepository(String type){
        return null;
    }


}
