package co.unicauca.restaurant.server.app.access;

import co.unicauca.serversocket.serversockettemplate.helpers.Utilities;


public class Factory {

    private static Factory instance;

    private Factory() {
    }

    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    public IFoodRepository getRepository() {
        String type = Utilities.loadProperty("customer.repository");

        if (type.isEmpty()) {
            type = "default";
        }

        FoodRepositoryImplArrays result = null;

        switch (type) {
            case "default":
                result = new FoodRepositoryImplArrays();
                break;
        }
        return result;
    }
}
