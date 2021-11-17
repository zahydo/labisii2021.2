package co.unicauca.domain;

import java.util.Map;

public class ParkingCostFactory {

    private Map<TypeEnum, IParkingCost> dictionary;
    private ParkingCostFactory instance;

    private void VehicleFactory(){

    }

    public ParkingCostFactory getInstance(){
        return instance;
    }

    public IParkingCost getParkingCost(TypeEnum veh){
        return dictionary.get(veh);
    }
}
