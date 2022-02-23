package co.edu.unicauca.commandrestaurant.access;

import co.edu.unicauca.commandrestaurant.access.adapter.FoodRepositoryJsonArrayAdapter;
import co.edu.unicauca.commandrestaurant.access.adapter.FoodRepositoryMapAdapter;
import co.edu.unicauca.commandrestaurant.infra.Utilities;

/**
 * Fabrica que se encarga de instanciar un repositorio concreto
 *
 * @author Libardo, Julio
 */
public class RepositoryFactory {

    private static RepositoryFactory instance;

    private RepositoryFactory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static RepositoryFactory getInstance() {

        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IProductRepository
     *
     * @return una clase hija de la abstracción IProductRepository
     */
    public IFoodRepository getRepository() throws Exception {

        IFoodRepository result = null;
        String type = Utilities.loadProperty("typeRepository");

        switch (type) {
            case "hash":
                result = new FoodRepositoryMapAdapter();
                break;
            case "crypto":
                result = new FoodRepositoryJsonArrayAdapter();
                break;
            case "default":
                result = new FoodImplArrayRepository();
                break;
        }

        return result;

    }
}
