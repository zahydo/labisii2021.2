/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.domain;

import java.util.EnumMap;
import java.util.Map;
/**
 * @author Dnaiel Cerón 
*/
public class ParkingCostFactory {

    private Map<TypeEnum, IParkingCost> dictionary;

    private static ParkingCostFactory instance;

    /**
     * singleton
     * @return instance, ParkingCostFactory
    */
    public static ParkingCostFactory getInstance() {
        if (instance == null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }

 
    private ParkingCostFactory() {
        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());

    }

    /**
     * @param type
     * @return result, IParkingCost
     */
    public IParkingCost getType(TypeEnum type) {
        IParkingCost result = null;
        if (dictionary.containsKey(type)) {
            result = dictionary.get(type);
        }
        return result;
    }
}