package co.edu.unicauca.layersmvc.access;

import co.edu.unicauca.layersmvc.infra.Utilities;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.edu.unicauca.layersmvc.infra.IPublisher;
import co.edu.unicauca.layersmvc.infra.Publisher;

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
            result = (IProductRepository) Class.forName(Utilities.loadProperty("repositoryClass")).getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result == null)
         result = new ProductRepository();
        return result;
    }

    /**
     * Método que crea una instancia concreta de la jerarquia IPublisher
     *
     * @return una clase hija de la abstracción IPlubisher
     */
    public IPublisher getPublisher() {  
        IPublisher result = null;
        
        try { 
            result = (IPublisher) Class.forName(Utilities.loadProperty("publisherClass")).getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result == null)
         result = new Publisher();
        return result;
    }
}
