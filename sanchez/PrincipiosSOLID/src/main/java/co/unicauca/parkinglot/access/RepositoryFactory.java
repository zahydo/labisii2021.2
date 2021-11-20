
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.CarParkingCost;
import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.MotoParkingCost;
import co.unicauca.parkinglot.domain.TruckParkingCost;
import co.unicauca.parkinglot.domain.TypeEnum;
import java.util.EnumMap;
import java.util.Map;

/**
 * @@authores Fabián David Marín(fabianxd0496@unicauca.edu.co) 
 *           Hector Fernando Dorado(hfdorado@unicauca.edu.co)
 *           Juan Sebastian Sánchez Pizo(spjuan@unicauca.edu.co)
 */
public class RepositoryFactory {

    private Map<TypeEnum, IParkingCost> deliveryDictionary;

    // Singleton
    private static RepositoryFactory instance;

    private RepositoryFactory() {
        deliveryDictionary = new EnumMap<>(TypeEnum.class);
        deliveryDictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
        deliveryDictionary.put(TypeEnum.CAR, new CarParkingCost());
        deliveryDictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        // Si se requie otro vehículo, se abre un registro en este diccionario
        // No se viola el principio porque este este modulo no está pensado
        // para que sea estable.
    }

    /**
     * Devuelve la instancia de la clase
     *
     * @return instancia unica de la la fábrica
     */
    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }

    public IParkingCost getVehiculo(TypeEnum vehiculo) {

        IParkingCost result = null;

        if (deliveryDictionary.containsKey(vehiculo)) {
            result = deliveryDictionary.get(vehiculo);
        }
        return result;
    }

    public IVehicleRepository getRepository(String type) {

        IVehicleRepository result = null;

        switch (type) {
            case "default":
                result = new VehicleRepository();
                break;
        }
        return result;
    }
}
