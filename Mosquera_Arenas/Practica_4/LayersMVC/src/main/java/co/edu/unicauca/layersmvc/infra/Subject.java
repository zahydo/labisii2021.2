package co.edu.unicauca.layersmvc.infra;

import co.unicauca.layersmvc.commons.Product;
import co.edu.unicauca.layersmvc.infra.Observer;
import co.unicauca.layersmvc.commons.EnviarProducto;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 * Sujeto, o tambien el observadoF
 *
 * @author ahurtado
 */
public abstract class Subject {

    ArrayList<Observer> observers;
    Publisher publicador = new Publisher();

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
    public void notifyAllObserves(Product producto,String accion) {
        enviar(producto,accion);

        for (Observer each : observers) {
            each.update(this);
        }
    }
    
    private void enviar(Product producto,String accion){
        
        EnviarProducto env_p = new EnviarProducto(producto,accion);
        Gson gson = new Gson();
        String msgJson = gson.toJson(env_p);
        publicador.publish(msgJson,"logs");
        
    }
    
}
