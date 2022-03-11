package co.unicauca.foodapp.client.access;

import co.unicauca.foodapp.commons.infra.Utilities;

/**
 * Fabrica que se encarga de instanciar FoodAccessImplSockets o cualquier
 * otro que se cree en el futuro.
 *
 * @author Diego Collazos, Eliana Cerquera
 */
public class Factory {

    /**
     * Instancia Singleton
     */
    private static Factory instance;

    /**
     * Constructor
     */
    private Factory() {}

    /**
     * Patron Singleton
     * @return instancia de singleton
     */
    public static Factory getInstance() {
        if (instance == null)
            instance = new Factory();
        return instance;
    }

    /**
     * Metodo que crea una instancia concreta de la jerarquia FoodService
     * @return una clase hija de la abstracción IFoodAccess
     */
    public IFoodAccess getFoodService() {
        IFoodAccess result = null;
        String type = Utilities.loadProperty("food.service");
        switch (type) {
            case "default":
                result = new FoodAccessImplSockets();
                break;
        }
        return result;
    }
}
