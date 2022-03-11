package co.unicauca.travelagency.client.access;

import co.unicauca.travelagency.commons.infra.Utilities;

/**
 * Fabrica que se encarga de instanciar CustomerServiceImplSockets o cualquier
 * otro que se cree en el futuro.
 *
 * @author Libardo, Julio
 */
public class Factory {

    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IFoodAccess
     *
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
