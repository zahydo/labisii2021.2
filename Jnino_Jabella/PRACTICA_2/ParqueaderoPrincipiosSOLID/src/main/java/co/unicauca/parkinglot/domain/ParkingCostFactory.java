package co.unicauca.parkinglot.domain;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author jnino_jabella
 */
public class ParkingCostFactory {

    private Map<TypeEnum, lParkingCost> dictionary;
    private static ParkingCostFactory instance;

    private ParkingCostFactory() {
        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
    }

    public static ParkingCostFactory getInstance() {
        if (instance == null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }

    public lParkingCost getParkingCost(TypeEnum vehicle) {
        lParkingCost result = null;
        if (dictionary.containsKey(vehicle)) {
            result = dictionary.get(vehicle);
        }
        return result;
    }
}
