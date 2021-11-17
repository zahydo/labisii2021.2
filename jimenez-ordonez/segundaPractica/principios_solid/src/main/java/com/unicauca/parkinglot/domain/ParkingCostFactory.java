package com.unicauca.parkinglot.domain;

import java.util.HashMap;
import java.util.Map;

public class ParkingCostFactory {

    private Map<TypeEnum, IParkingCost> dictionary;
    private static ParkingCostFactory instance;
    
    private ParkingCostFactory() {
        super();
        dictionary = new HashMap<>();
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
    }

    
    /** 
     * @return ParkingCostFactory
     */
    public static ParkingCostFactory getInstance() {
        if (ParkingCostFactory.instance == null){
            ParkingCostFactory.instance = new ParkingCostFactory();
        } 
        return ParkingCostFactory.instance;
    }

    
    /** 
     * @param veh
     * @return IParkingCost
     */
    public IParkingCost getParkingCost(TypeEnum veh) {
        return dictionary.get(veh);
    }

}
