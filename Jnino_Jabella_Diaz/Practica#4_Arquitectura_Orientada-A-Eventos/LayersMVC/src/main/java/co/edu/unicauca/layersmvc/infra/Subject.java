package co.edu.unicauca.layersmvc.infra;

import co.edu.unicauca.layersmvc.infra.Observer;
import co.edu.unicauca.layersmvc.presentation.GUIAddProductViewController;
import co.unicauca.rabbitmq.Emisor.EmitLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void notifyAllObserves(String prmEtiqueta,String prmDatosProductos,String prmTipoAccion){
        NotificarSuscriptores(prmEtiqueta,prmDatosProductos,prmTipoAccion);
    }
    
    private void NotificarSuscriptores(String prmEtiqueta,String prmDatosProductos,String prmTipoAccion){
        try {          
            EmitLog.Publish(prmEtiqueta+"_"+prmDatosProductos+"_"+prmTipoAccion);
        } catch (IOException | TimeoutException ex) {
            Logger.getLogger(GUIAddProductViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
}  

}
