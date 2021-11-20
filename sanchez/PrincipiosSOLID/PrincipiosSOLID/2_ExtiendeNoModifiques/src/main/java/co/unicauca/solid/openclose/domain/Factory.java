package co.unicauca.solid.openclose.domain;

import java.util.EnumMap;
import java.util.Map;

/**
 * Fábrica que utiliza el patrón de diseño Singleton
 *
 * @author Libardo, Julio
 */
public class Factory {

    private Map<CountryEnum, IDelivery> deliveryDictionary;

    // Singleton
    private static Factory instance;

    private Factory() {
        deliveryDictionary = new EnumMap<>(CountryEnum.class);
        deliveryDictionary.put(CountryEnum.COLOMBIA, new ColombiaDelivery());
        deliveryDictionary.put(CountryEnum.MEXICO, new MexicoDelivery());
        // Si se requie otto pais, se abre un registro en este diccionario
        // No se viola el principio porque este este modulo no está pensado
        // para que sea estable.
    }

    /**
     * Devuelve la instancia de la clase
     *
     * @return instancia unica de la la fábrica
     */

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    /**
     * Para un pais determina la clase que se encarga de calcular el costo del
     * envío.
     *
     * @param country
     * @return
     */
    public IDelivery getDelivery(CountryEnum country) {

        IDelivery result = null;

        if (deliveryDictionary.containsKey(country)) {
            result = deliveryDictionary.get(country);
        }

        return result;

    }
}
