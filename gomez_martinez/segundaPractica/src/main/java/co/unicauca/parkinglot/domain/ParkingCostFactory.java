package co.unicauca.parkinglot.domain;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author angiecgomez
 * @author mafemartinez
 */
public class ParkingCostFactory {
    
    /**
     * Attributes
     */
    
    private Map <TypeEnum, IParkingCost> dictionary;
    private static ParkingCostFactory instance;

    
    /**
     * Constructor
     */
    
    private ParkingCostFactory() {
        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
        this.dictionary = dictionary;
    }

    /**
     * Gets the only instance of the class
     * @return instance
     */
    public static ParkingCostFactory getInstance() {
        if(instance == null){
            instance = new ParkingCostFactory();
        }
        return instance;
    }
    
    /**
     * Methods
     */
    
    /**
     * 
     * @param veh
     * @return 
     */
    
    public IParkingCost getParkingCost(TypeEnum veh){
        IParkingCost result = null;
        if(dictionary.containsKey(veh)){
            result = dictionary.get(veh);
        }
        return result;
    }
    
    
    
    
   
    
}
