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
 * @author Kevin Daryany Morales
 */
public class ParkingCostFactory {
    private Map<TypeEnum,IParkingCost> costDictionary;
    
    //Singleton
       private static ParkingCostFactory instance;

    private ParkingCostFactory() {
        costDictionary = new EnumMap<>(TypeEnum.class);
        costDictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        costDictionary.put(TypeEnum.CAR, new CarParkingCost());
        costDictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
        // Si se requiere otro tipo de carro, se abre un registro en este diccionario
        // No se viola el principio porque este este modulo no está pensado
        // para que sea estable.
    }
    
    /**
     * Devuelve la instacia de una clase
     * @return instancia unica de la fabrica
     */
    public static ParkingCostFactory getInstance(){
        if (instance==null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }
    /**
     * 
     * @param type
     * @return 
     */
    public IParkingCost getRepository(TypeEnum type){
        IParkingCost result = null;
        if (costDictionary.containsKey(type)) {
            result = costDictionary.get(type);
        }
        return result;
    }
}
