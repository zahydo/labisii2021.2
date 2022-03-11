package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.infra.Utilities;
import co.unicauca.restaurant.server.access.CustomerRepositoryImplArrays;

/**
 * Fabrica que se encarga de instanciar un repositorio concreto
 *
 * @author Libardo, Julio
 */
public class CustomerFactory {

    private static CustomerFactory instance;

    private CustomerFactory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static CustomerFactory getInstance() {

        if (instance == null) {
            instance = new CustomerFactory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia
     * ICustomerRepository
     *
     * @return una clase hija de la abstracción IRepositorioClientes
     */
    public ICustomerRepository getRepository() {
        String type = Utilities.loadProperty("customer.repository");
        if (type.isEmpty()) {
            type = "default";
        }
        ICustomerRepository result = null;

        switch (type) {
            case "default":
                result = new CustomerRepositoryImplArrays();
                break;
            case "mysql":
                result = new CustomerRepositoryImplMysql();
                break;
        }

        return result;

    }
}
