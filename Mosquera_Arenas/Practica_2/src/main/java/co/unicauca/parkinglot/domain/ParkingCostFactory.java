/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.domain;

import java.util.EnumMap;
import java.util.Map;

/**
 * Fabrica instancias de los respectivos vehiculos deacuerdo al argumento de entrada
 * @fecha 2021/11/17
 * @author Miguel Mosquera, Sebastian Arenas
 */
public class ParkingCostFactory {
    
    private Map<TypeEnum, IParkingCost> dictionary; //Diccionario que almacena las isntancias de la intefaz de IParkingCost
    
    // Singleton
    private static ParkingCostFactory instance; //Instancia unica de esta clase
    
    
    /** 
     * Constructor que inicia y llena el diccionario
     */
    private ParkingCostFactory(){
        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.CARRO, new CarParkingCost());
        dictionary.put(TypeEnum.CAMION, new TruckParkingCost());
    }
    
    /**
     * Devuelve la instancia de la clase
     *
     * @return instancia unica de la la fábrica
     */

    public static ParkingCostFactory getInstance() {
        if (instance == null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }
    
    /**
     * Dterminar que costo calcular deacuerdo al tipo de vehiculo que recibe
     * envío.
     *
     * @param vehiculo
     * @return IParkingCost
     */
    public IParkingCost getParkingCost(TypeEnum vehiculo) {

        IParkingCost result = null;

        if (dictionary.containsKey(vehiculo)) {
            result = dictionary.get(vehiculo);
        }

        return result;
    }
    
}
