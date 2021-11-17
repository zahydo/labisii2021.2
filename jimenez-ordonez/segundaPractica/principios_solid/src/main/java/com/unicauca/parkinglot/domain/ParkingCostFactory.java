package com.unicauca.parkinglot.domain;

import java.util.HashMap;
import java.util.Map;

public class ParkingCostFactory {

    private Map<TypeEnum, IParkingCost> dictionary;
    private ParkingCostFactory instance;

    public ParkingCostFactory() {
        super();
        dictionary = new HashMap<>();
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
    }

    private void VehicleFactory() {
    }

    public ParkingCostFactory getInstance() {
        instance = (instance == null) ? new ParkingCostFactory() : instance;
        return instance;
    }

    public IParkingCost getParkingCost(TypeEnum veh) {
        return dictionary.get(veh);
    }

}
