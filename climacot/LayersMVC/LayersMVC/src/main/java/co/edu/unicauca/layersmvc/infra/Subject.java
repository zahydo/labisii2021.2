package co.edu.unicauca.layersmvc.infra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import co.edu.unicauca.layersmvc.domain.Response;

/**
 * Sujeto, o tambien el observadoF
 *
 * @author ahurtado
 */
public abstract class Subject {

    ArrayList<Observer> observers;

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
     * 
     * @throws TimeoutException
     * @throws IOException
     */
    public void notifyAllObserves() {
        // notifyAllSuscipters(response);
        for (Observer each : observers)
            each.update(this);
    }

    public void notifyAllSuscipters(Response response) {
        PublicadorRabbit rb = new PublicadorRabbit();
        try {
            rb.publicar(response);
        } catch (Exception e) {
        }
    }
}
