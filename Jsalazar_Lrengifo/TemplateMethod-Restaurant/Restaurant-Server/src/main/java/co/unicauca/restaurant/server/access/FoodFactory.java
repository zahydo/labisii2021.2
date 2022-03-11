package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.infra.Utilities;

/**
 *
 * @author Libardo Julio
 */
public class FoodFactory {

    private static FoodFactory instance;

    private FoodFactory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static FoodFactory getInstance() {

        if (instance == null) {
            instance = new FoodFactory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia
     * IFoodRepository
     *
     * @return una clase hija de la abstracción IFoodRepository
     */
    public IFoodRepository getRepository() {
        String type = Utilities.loadProperty("customer.repository");
        if (type.isEmpty()) {
            type = "default";
        }
        IFoodRepository result = null;

        switch (type) {
            case "default":
                result = new FoodRepositoryImplArrays();
                break;
            case "mysql":
                // TODO: Agregar soporte de MySql
                // result = new FoodRepositoryImplMysql();
                result = new FoodRepositoryImplArrays();
                break;
        }

        return result;

    }
}
