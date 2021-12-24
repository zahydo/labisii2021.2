package co.edu.unicauca.Subscriptor1.presentation;

import co.edu.unicauca.Subscriptor1.subscriber.Subscriptor;
import co.edu.unicauca.Subscriptor1.domain.service.ServiceModel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Libardo, Julio
 */
public class ClientMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ClientMain().execute();
    }

    public void execute() {
        ServiceModel model = new ServiceModel();
        Subscriptor sub = new Subscriptor(model);

        // Inyección de dependencias
            //GUIAddProductViewController instance = new GUIAddProductViewController(model);
            //instance.setVisible(true);
            model.addObserver(new GUIListProductViewController(model));
            model.addObserver(new GUIListProductOtherViewController(model));
        
        //model.saveProduct(producto);
        
        try {
            sub.recibir_mensaje();
        } catch (Exception ex) {
            Logger.getLogger(ClientMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
