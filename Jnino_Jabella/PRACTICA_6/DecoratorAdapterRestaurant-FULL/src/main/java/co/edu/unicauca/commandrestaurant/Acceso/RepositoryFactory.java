package co.edu.unicauca.commandrestaurant.Acceso;

import co.edu.unicauca.commandrestaurant.Acceso.Adapter.FoodRepositoryMapAdapter;
import co.edu.unicauca.commandrestaurant.Acceso.Adapter.FoodRepositoryJsonArrayAdapter;
import co.edu.unicauca.commandrestaurant.Infra.Utilidades;

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
    public Interface_ComidaRepository getRepository() {

        Interface_ComidaRepository result = null;
        String type = Utilidades.loadProperty("typeRepository");

        switch (type) {
            case "json":
                result = new FoodRepositoryJsonArrayAdapter();
                break;
            case "hash":
                result = new FoodRepositoryMapAdapter();
                break;
            case "default":
                result = new ComidaArrayRepository();
                break;
        }

        return result;

    }
}
