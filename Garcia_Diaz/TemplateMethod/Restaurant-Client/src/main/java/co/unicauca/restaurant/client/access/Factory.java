
package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.commons.infra.Utilities;

/**
 *
 * @author Anderson Diaz
 */
public class Factory {
    private static Factory instance;

    private Factory() {
    }

    /**
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

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
