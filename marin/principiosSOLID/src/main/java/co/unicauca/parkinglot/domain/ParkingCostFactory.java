
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;

/**
 * Fábrica de que utiliza el patrón de diseño Singleton para generar una
 * instancia de la interfaz IParkingCost
 *
 * @authores Fabián David Marín(fabianxd0496@unicauca.edu.co) 
 *           Hector Fernando Dorado(hfdorado@unicauca.edu.co)
 *           Juan Sebastian Sánchez Pizo(spjuan@unicauca.edu.co)
 */
public class ParkingCostFactory {

    private Map<TypeEnum, IParkingCost> dictionary;

    // Singleton
    private static ParkingCostFactory instance;

    private ParkingCostFactory() {
        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
        // Si se requie otro vehiculo, se abre un registro en este diccionario
        // No se viola el principio porque este este modulo no está pensado para que se mantenga estable.
    }

    public long CalculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        return 0;
    }
}
