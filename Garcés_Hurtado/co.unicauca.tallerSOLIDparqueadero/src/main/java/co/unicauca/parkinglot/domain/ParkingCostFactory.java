/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author Yahir Garcés
 */
public class ParkingCostFactory {
    private Map<TypeEnum, IParkingCost> dictionary;
    private static ParkingCostFactory instance;

    public ParkingCostFactory() {
        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.MOTO,  new MotoParkingCost());
        dictionary.put(TypeEnum.CAR,  new CarParkingCost());
        dictionary.put(TypeEnum.TRUCK,  new TruckParkingCost());
    }
    
    public static ParkingCostFactory getInstance() {
        if (instance == null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }
    
    public IParkingCost getParkingCost(TypeEnum veh){
        IParkingCost result = null;
        switch (veh) {
            case MOTO :
                result = new MotoParkingCost();
                break;
            case CAR :
                result = new CarParkingCost();
                break;
            case TRUCK :
                result = new TruckParkingCost();
                break;
        }
        return result;   
    }
}
