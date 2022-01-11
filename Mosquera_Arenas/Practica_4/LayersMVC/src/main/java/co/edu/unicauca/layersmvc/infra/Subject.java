package co.edu.unicauca.layersmvc.infra;

import co.unicauca.layersmvc.commons.Product;
import co.edu.unicauca.layersmvc.infra.Observer;
import co.unicauca.layersmvc.commons.Product_protocol;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 * Sujeto, o tambien el observadoF
 *
 * @author ahurtado
 */
public abstract class Subject {

    ArrayList<Observer> observers;
   
    public void Subject() {

    }

    /**
     * Agrega un observador
     *
     * @param obs
     */
    public void addObserver(Observer obs) {
        if (observers == null) {
            observers = new ArrayList<>();
        }
        observers.add(obs);
    }

    /**
     * Notifica a todos los observadores que hubo un cambio en el modelo
     */
    public void notifyAllObserves() {

        for (Observer each : observers) {
            each.update(this);
        }
    }
    
    
    
}
