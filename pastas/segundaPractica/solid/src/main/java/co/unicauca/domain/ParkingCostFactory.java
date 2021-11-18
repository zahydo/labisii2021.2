package co.unicauca.domain;

import java.util.EnumMap;
import java.util.Map;

public class ParkingCostFactory {

    private Map<TypeEnum, IParkingCost> dictionary;
    private static ParkingCostFactory instance;
    //Singleton?
    
    private ParkingCostFactory(){
        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
    }

    
    /** 
     * @return ParkingCostFactory
     */
    public static ParkingCostFactory getInstance(){
        if (instance == null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }

    
    /** 
     * @param veh
     * @return IParkingCost
     */
    public IParkingCost getType(TypeEnum veh) {
        IParkingCost result = null;
        if (dictionary.containsKey(veh)) {
            result = dictionary.get(veh);
        }
        return result;
    }
}
