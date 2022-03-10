package co.unicauca.restaurant.server.access;

import co.unicauca.Restaurant.commons.infra.Utilities;

/**
 * Fabrica que se encarga de instanciar un repositorio concreto
 *
 * @author pdaniel
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
     * Método que crea una instancia concreta de la jerarquia
     * IFoodRepository
     *
     * @return una clase hija de la abstracción IRepositorioClientes
     */
    public IFoodRepository getRepository() {
        String type = Utilities.loadProperty("customer.repository");
        if (type.isEmpty()) {
            type = "default";
        }
        IFoodRepository result = null;

        switch (type) {
            case "default":
                result = new FoodImplArrayRepository();
                break;
        }

        return result;

    }
}
