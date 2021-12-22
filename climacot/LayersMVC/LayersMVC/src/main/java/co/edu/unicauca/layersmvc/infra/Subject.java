package co.edu.unicauca.layersmvc.infra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

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
    public void notifyAllObserves(String response) throws IOException, TimeoutException {
        notifyAllSuscipters(response);
        for (Observer each : observers)
            each.update(this);
    }

    public void notifyAllSuscipters(String response) {
        PublicadorRabbit rb = new PublicadorRabbit();
        try {
            rb.publicar(response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
