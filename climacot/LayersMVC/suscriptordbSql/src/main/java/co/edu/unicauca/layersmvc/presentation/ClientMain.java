package co.edu.unicauca.layersmvc.presentation;

import co.edu.unicauca.layersmvc.domain.Response;
import co.edu.unicauca.layersmvc.domain.service.ServiceModel;
import co.edu.unicauca.layersmvc.infra.RabbitController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 *
 * @author Libardo, Julio
 */
public class ClientMain {
    private static final String EXCHANGE_NAME = "logs";
    private static final String IP = "localhost";

    public static void main(String[] args) throws Exception {
        RabbitController controladorRabbit = new RabbitController(IP);
        controladorRabbit.configChannel();       
        
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            controladorRabbit.processRequest(message);
            controladorRabbit.getModel().listProducts().stream().forEach((x) -> System.out.println(x.toString()));
        };
        
        controladorRabbit.getChannel().basicConsume(controladorRabbit.getQueueName(), true, deliverCallback, consumerTag -> {
        });
    }
}
