package co.mycompany.restaurant.server.access;

import co.mycompany.restaurant.commons.infra.Utilities;

/**
 * @author Fabián David Marín - Hector Fernando Dorado
 * 
 * Esta clase instancia el repositorio 
 */
public class Factory {

    /**
     * atributos
     */
    
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
     * Metodo que crea una instancia del repositorio
     *
     * @return una instancia segun sea el repositorio
     */
    public IPlatoRepository getRepository() {
        String type = Utilities.loadProperty("plato.repository");
        if (type.isEmpty()) {
            type = "default";
        }
        IPlatoRepository result = null;

        switch (type) {
            case "default":
                result = new PlatoRepositoryImplArrays();
                break;
        }
        return result;

    }
}
