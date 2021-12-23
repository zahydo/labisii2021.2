package co.edu.unicauca.suscriptor.infra;

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
    public void notifyAllObserves(String prmCadenaGson) {
        
        for (Observer each : observers) {
            each.update(this);
        }
    }

}
