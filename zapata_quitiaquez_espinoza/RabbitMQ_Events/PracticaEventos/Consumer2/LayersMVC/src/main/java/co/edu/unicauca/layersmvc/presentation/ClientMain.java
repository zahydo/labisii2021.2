package co.edu.unicauca.layersmvc.presentation;

import co.edu.unicauca.layersmvc.domain.service.ServiceModel;
import co.edu.unicauca.layersmvc.infra.RabbitMQConsumer;

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
        System.out.println("Loading app");
        ServiceModel model = new ServiceModel();
        RabbitMQConsumer consumer = new RabbitMQConsumer(model);
        consumer.consume();
        // Inyección de dependencias
     
        
    }
}
