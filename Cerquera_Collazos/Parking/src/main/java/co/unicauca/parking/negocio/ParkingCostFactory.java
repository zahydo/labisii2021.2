/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parking.negocio;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author Yenny Eliana Cerquera Yacumal - Sebastián Collazos
 */
public class ParkingCostFactory {
    private Map<TypeEnum, IParkingCost> dictionary;
    private ParkingCostFactory instance;

    public ParkingCostFactory() {
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
        
    }
    
    private void vehicleFactory() {
        
    } 

    public ParkingCostFactory getInstance() {
        return instance;
    }
    
    public IParkingCost getParkingCost(TypeEnum vehiculo) {
        
        return 
    }
}
