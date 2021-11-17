package com.unicauca.parkinglot.domain;

import java.util.Map;

public class ParkingCostFactory {
    
    private Map<TypeEnum, IParkingCost> dictionary;
    private ParkingCostFactory instance;

    private void VehicleFactory(){
        //TODO: ¿?
    }    

    public ParkingCostFactory getInstance() {
        instance = (instance == null)? new ParkingCostFactory(): instance;
        return instance;
    }

    public IParkingCost getParkingCost(TypeEnum veh){
        return null;
    }

}
