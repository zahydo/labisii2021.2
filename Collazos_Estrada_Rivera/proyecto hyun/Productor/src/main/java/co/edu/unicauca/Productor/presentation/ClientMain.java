package co.edu.unicauca.Productor.presentation;

import co.edu.unicauca.Productor.domain.service.ServiceModel;

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
        // Inyección de dependencias
        GUIAddProductViewController instance = new GUIAddProductViewController(model);
        instance.setVisible(true);
        model.addObserver(new GUIListProductViewController(model));
        model.addObserver(new GUIListProductOtherViewController(model));
    }

}
