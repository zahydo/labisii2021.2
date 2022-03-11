package co.edu.unicauca.layersmvc.access;

import co.edu.unicauca.layersmvc.infra.Utilities;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Fabrica que se encarga de instanciar ProductRepository o cualquier otro que
 * se cree en el futuro.
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
     * Método que crea una instancia concreta de la jerarquia IProductRepository
     *
     * @return una clase hija de la abstracción IProductRepository
     */
    public IProductRepository getRepository() {
        IProductRepository result = null;

        try {

            String type = Utilities.loadProperty("subscriber.repository");
            if (type.isEmpty()) {
                type = "memory";
            }
            switch (type) {
                case "memory":
                    System.out.println("[x] :" + " " + "Save in Memory");
                    result = (IProductRepository) Class.forName(Utilities.loadProperty("repositoryClassArrays")).getConstructor().newInstance();
                    break;
                case "mysql":
                    System.out.println("[x] :" + " " + "Save in MySql");
                    result = (IProductRepository) Class.forName(Utilities.loadProperty("repositoryClassMySql")).getConstructor().newInstance();
                    break;
            }
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == null) {
            result = new ProductRepository();
        }
        return result;
    }
}
