package co.mycompany.restaurante.server.access;

import co.mycompany.restaurante.commons.infra.Utilities;

/**
 * Fabrica que se encarga de instanciar un repositorio concreto
 *
 * @author Kevin Morales
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
    IRestauranteRepository
     *
     * @return una clase hija de la abstracción IRepositorioClientes
     */
    public IRestauranteRepository getRepository() {
        String type = Utilities.loadProperty("restaurante.repository");
        if (type.isEmpty()) {
            //type = "default";
            type = "mysql";
        }
        IRestauranteRepository result = null;

        switch (type) {
            case "default":
                result = new RestauranteRepositoryImplArrays();
                break;
            case "mysql":
                result = new RestauranteRepositoryImplMysql();
                break;
        }
        return result;

    }
}
