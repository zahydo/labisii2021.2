package co.unicauca.parkinglot.domain;

import java.util.Map;

public class ParkingCostFactory {
    private Map<TypeEnum, IParkingCost> Dictionary; 
    private static ParkingCostFactory instance; 
    
    private ParkingCostFactory(){
        Dictionary.put(TypeEnum.CAR, new CarParkingCost()); 
        Dictionary.put(TypeEnum.MOTO, new MotoParkingCost()); 
        Dictionary.put(TypeEnum.TRUCK, new TruckParkingCost()); 
    }
    
    public static ParkingCostFactory getInstance(){
        if(instance == null){
            instance = new ParkingCostFactory(); 
        }
        return instance;  
    }
    
    public IParkingCost getParkingCost(TypeEnum veh){
        IParkingCost result = null; 
        if(Dictionary.containsKey(veh)){
            result = Dictionary.get(veh); 
        }
        return result;  
    }
    
    
    
    
}
