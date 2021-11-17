/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import com.unicauca.parkinglot.access.RepositoryFactory;
import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author 57322
 */
public class ParkingCostFactory {

    private Map<TypeEnum, IParkingCost> Dictionary;
    private static ParkingCostFactory instance;

    private ParkingCostFactory() {

        Dictionary = new EnumMap<>(TypeEnum.class);
        Dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        Dictionary.put(TypeEnum.CAR, new CarParkingCost());
        Dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());

    }

    public static ParkingCostFactory getInstance() {
        if (instance == null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }

    public IParkingCost getParkingCost(TypeEnum veh) {

        IParkingCost result = null;

        if (Dictionary.containsKey(veh)) {
            result = Dictionary.get(veh);
        }

        return result;

    }

}
