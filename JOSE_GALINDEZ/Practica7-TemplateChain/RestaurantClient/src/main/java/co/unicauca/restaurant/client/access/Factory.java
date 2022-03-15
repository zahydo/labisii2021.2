package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.client.infra.Utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
