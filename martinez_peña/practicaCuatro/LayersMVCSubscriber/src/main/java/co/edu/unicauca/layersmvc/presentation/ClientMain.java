package co.edu.unicauca.layersmvc.presentation;
import co.edu.unicauca.layersmvc.domain.service.ServiceModel;
import co.edu.unicauca.layersmvc.infra.RabbitMqSubscriber;


/**
 *
 * @author Libardo, Julio
 */
public class ClientMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        RabbitMqSubscriber Subscriber = new RabbitMqSubscriber();
        Subscriber.Subscriber();
    }



}
