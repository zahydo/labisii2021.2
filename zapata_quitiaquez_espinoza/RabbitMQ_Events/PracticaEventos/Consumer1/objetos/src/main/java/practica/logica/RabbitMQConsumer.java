package practica.logica;


import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Delivery;

import practica.baseDatos.DataBase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class RabbitMQConsumer {

    private final static String QUEUE_NAME = "layers-mvc";
    public static final String QUEUE_HOST = "localhost";
    private final Gson gson;
    private DataBase mongoConnection;

    public RabbitMQConsumer(DataBase mongoIn) {
        gson = new Gson();
        mongoConnection = mongoIn;
    }

    public void consume() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(QUEUE_HOST);
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare("LOGS", "fanout");
            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, "LOGS", "");
           // channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for messages");

            channel.basicConsume(queueName, true, this::processMessage, consumerTag -> {
            });
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }

    }

    private void processMessage(String consumerTag, Delivery delivery) {
        String serializedMessage = new String(delivery.getBody(), StandardCharsets.UTF_8);
        ProductMessage productMessage = gson.fromJson(serializedMessage, ProductMessage.class);
        Product product = productMessage.getProduct();
        ProductAction productAction = productMessage.getAction();
        System.out.println(" [x] Received '" + product.getName() + ", action = " + productAction);
        mongoConnection.accion(productMessage);
    }

}