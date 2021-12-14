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
 * @author Andres Garcia
 * @author Felipe Garcia
 */
public class ParkingCostFactory {

    private Map<TypeEnum, IParkingCost> dictionary;

    private static ParkingCostFactory instance;

    /**
     * Devuelve instancia unica de la clase
     *
     * @return instance, ParkingCostFactory
     */
    public static ParkingCostFactory getInstance() {
        if (instance == null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }

    /**
     * Diccionario
     */
    private ParkingCostFactory() {
        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());

    }

    /**
     * recibe un TypeEnum para seleccionar una instancia de IParkingCost
     *
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
