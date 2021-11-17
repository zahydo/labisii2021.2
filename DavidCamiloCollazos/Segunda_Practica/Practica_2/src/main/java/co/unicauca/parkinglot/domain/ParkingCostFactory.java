/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.domain;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author David E
 */
public class ParkingCostFactory {
    private Map<TypeEnum,IParkingCost> dictionary;
    
    private static ParkingCostFactory instance;
    
    /**
     * constructor incializa el diccionario
     * 
     */
    private ParkingCostFactory(){
       dictionary =  new EnumMap<>(TypeEnum.class);
       dictionary.put(TypeEnum.CAR, new CarParkingCost());
       dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
       dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
    }
    

    /**
     * @return the instance
     */
    public static ParkingCostFactory getInstance() {
        if(instance == null){
            instance = new ParkingCostFactory();
        }
        return instance;
    }
    
    /**
     * @return the instance
     */
    public IParkingCost getParkingCost(TypeEnum veh){
        
        IParkingCost interf =  null;
        
        if(dictionary.containsKey(veh)){
           interf = dictionary.get(veh);
        }
        
        return interf;
    }
    
}
