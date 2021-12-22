package co.edu.unicauca.layersmvc.infra;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class PublicadorRabbit implements Publisher {
    private static String HOST_RABBITMQ = "b-eccdea82-2c7f-4fd2-a90b-a689482b8c09.mq.us-east-2.amazonaws.com";
    private static String HOST_RABBITMQ_LOCAL = "localhost";
    private ConnectionFactory factory;

    public PublicadorRabbit() {
        this.factory = new ConnectionFactory();
        /*
         * quitar los comentarios y usar HOST_RABBITMQ para conectarse a un servicio de
         * aws y comunicarse por la web
         */
        // factory.setUsername("climaco1");
        // factory.setPassword("computadorgamer1");
        factory.setHost(HOST_RABBITMQ_LOCAL);
        // factory.setPort(5671);
        // try {
        // factory.useSslProtocol();
        // } catch (Exception e) {
        // }
    }

    @Override
    public void publicar(String response) throws IOException, TimeoutException {
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.exchangeDeclare("logs", "fanout");
            channel.basicPublish("logs", "", null, response.getBytes("UTF-8"));
        }
    }
}
