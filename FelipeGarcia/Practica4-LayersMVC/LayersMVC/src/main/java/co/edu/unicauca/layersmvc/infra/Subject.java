package co.edu.unicauca.layersmvc.infra;

import co.edu.unicauca.layersmvc.infra.Observer;

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
        Publicador objPublicador = new Publicador();
        
        try {
            objPublicador.Publicar(prmCadenaGson);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        
        for (Observer each : observers) {
            each.update(this);
        }
    }

}
