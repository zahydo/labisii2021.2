package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.commons.infra.Utilities;



/**
 * Fabrica que se encarga de instanciar FoodAccessImplSockets o cualquier
 * otro que se cree en el futuro.
 *
 * @author Libardo, Julio
 */
public class Factory {

    private static Factory instance;

    private Factory() {
    }

    /**
     * Constructor de tipo Singleton.
     * @return instance Factory. La misma instancia para toda la app.
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IFoodAccess
     * @return result IFoodAccess. Una clase hija de la abstracción IFoodAccess
     */
    public IFoodAccess getFoodService() {

        IFoodAccess result = null;
        String type = Utilities.loadProperty("food.service");

        switch (type) {
            case "default":
                result = new FoodAccessImplSocket();
                break;
        }

        return result;

    }
}
