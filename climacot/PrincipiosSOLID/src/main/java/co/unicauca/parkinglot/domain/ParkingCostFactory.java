/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.util.EnumMap;
import java.util.Map;

/**
 * Fábrica de que utiliza el patrón de diseño Singleton para generar una
 * instancia de la interfaz IParkingCost
 *
 * @author Libardo, Julio
 */
public class ParkingCostFactory {

    private Map<TypeEnum, IParkingCost> dictionary;

    // Singleton
    private static ParkingCostFactory instance;

    /**
     * Devuelve la instancia de la clase
     *
     * @return instancia unica de ParkingCostFactory
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
     * instancia de iparkingcost para un TypeEnum
     *
     * @param type
     * @return retorna una instancia de iparkingcost para calcular el costo
     */
    public IParkingCost getType(TypeEnum type) {
        IParkingCost result = null;
        if (dictionary.containsKey(type)) {
            result = dictionary.get(type);
        }
        return result;
    }
}
