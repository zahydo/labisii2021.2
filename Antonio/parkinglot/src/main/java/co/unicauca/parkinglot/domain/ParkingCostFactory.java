/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.domain;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author Antonio E
 */
public class ParkingCostFactory {
    
    private Map<TypeEnum,IParkingCost> dictionary;
    private static ParkingCostFactory instance;

    private ParkingCostFactory() {
        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
        
    }
    
    public static ParkingCostFactory getInstance(){
        if (instance==null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }
    
    
    public IParkingCost getRepository(TypeEnum type){
        IParkingCost result = null;
        if (dictionary.containsKey(type)) {
            result = dictionary.get(type);
        }
        return result;
    }
    
}
