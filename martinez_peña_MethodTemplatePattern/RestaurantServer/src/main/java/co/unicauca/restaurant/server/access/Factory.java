package co.unicauca.restaurant.server.access;

import co.unicauca.travelagency.commons.infra.Utilities;

/**
 * Fabrica que se encarga de instanciar un repositorio concreto
 *
 * @author Julian Martinez, Paula Peña
 */
public class Factory {

    private static Factory instance;

    private Factory() {
    }

    /**
     * Singleton Pattern
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
     * Se retorna el repositorio, para el restaurante será por medio de arrays
     *
     * @return
     */
    public IRepository getRepository() {
        String repo = (Utilities.loadProperty("restaurant.service"));
        switch (repo) {
            case "default":
                return new RepositoryImpArrays();
            default:
                return new RepositoryImpArrays();
        }

    }
}
