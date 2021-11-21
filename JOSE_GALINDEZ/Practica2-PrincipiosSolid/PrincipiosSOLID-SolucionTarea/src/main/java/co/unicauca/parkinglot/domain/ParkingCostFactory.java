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
 * @author Jose_R
 */
public class ParkingCostFactory {

    private Map<TypeEnum, IParkingCost> dictionary;

    // Singleton
    private static ParkingCostFactory instance;
    /**
     * Metodo constructor de fabricacion para calcular costos de paqueo
     */
    private ParkingCostFactory() {
        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
    }
    /**
     * Retorna la instancia para el costro de parqueo, si no existe crea una
     * @return la instancia
     */
    public static ParkingCostFactory getInstance() {
        if (instance == null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }
    /**
     * Revisa los tipos de vehiculos existentes en el diccionario para poder 
     * indicar las caracteristicas del mismo
     * @param type tipo de vehiculo 
     * @return la instancia del vehiculo
     */
    public IParkingCost getParking(TypeEnum type) {

        IParkingCost result = null;

        if (dictionary.containsKey(type)) {
            result = dictionary.get(type);
        }

        return result;

    }

}
