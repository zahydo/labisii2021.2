package co.unicauca.travelagency.server.access;

import co.unicauca.travelagency.commons.infra.Utilities;

/**
 * Fabrica que se encarga de instanciar un repositorio concreto
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
     * Método que crea una instancia concreta de la jerarquia
     * ICustomerRepository
     *
     * @return una clase hija de la abstracción IRepositorioClientes
     */
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
