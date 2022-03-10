package co.unicauca.Restaurante.client.access;

import co.unicauca.Restaurante.commons.infra.Utilities;

/**
 * Fabrica que se encarga de instanciar FoodServiceImplSockets o cualquier
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
     * Método que crea una instancia concreta de la jerarquia IFoodService
     *
     * @return una clase hija de la abstracción IRepositorioClientes
     */
    public IFoodAccess getFoodService() {

        IFoodAccess result = null;
        String type = Utilities.loadProperty("customer.service");

        switch (type) {
            case "default":
                result = new FoodAccessImplSockets();
                break;
        }

        return result;

    }
}
