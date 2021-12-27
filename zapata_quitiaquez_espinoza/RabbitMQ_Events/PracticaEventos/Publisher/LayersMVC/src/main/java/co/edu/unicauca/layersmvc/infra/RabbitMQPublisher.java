package co.edu.unicauca.layersmvc.infra;

import co.edu.unicauca.layersmvc.domain.Product;
import co.edu.unicauca.layersmvc.domain.ProductAction;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class RabbitMQPublisher {

    private final static String QUEUE_NAME = "layers-mvc";
    private final static String QUEUE_NAME2 = "layers-mvc2";
    private final static String QUEUE_HOST = "localhost";
    private final Gson gson;

    public RabbitMQPublisher() {
        gson = new Gson();
    }

    public void publish(Product product, ProductAction action) {
        ProductMessage productMessage = new ProductMessage(product, action);
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(QUEUE_HOST);
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
        	channel.exchangeDeclare("LOGS", "fanout");
            //channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String serializedMessage = gson.toJson(productMessage);
            channel.basicPublish("LOGS", QUEUE_NAME, null, serializedMessage.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + serializedMessage + "'");
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
      
    }
   
}