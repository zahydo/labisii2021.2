package co.edu.unicauca.layersmvc.infra;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import co.edu.unicauca.layersmvc.domain.Response;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class PublicadorRabbit implements Publisher {
    private static String HOST_RABBITMQ = "b-132dd872-4555-48c5-a7e6-b6352d232e3b.mq.us-east-2.amazonaws.com";
    // private static String HOST_RABBITMQ_LOCAL = "localhost";
    private ConnectionFactory factory;

    public PublicadorRabbit() {
        this.factory = new ConnectionFactory();
        // factory.setHost(HOST_RABBITMQ_LOCAL);
        /*
         * quitar los comentarios y usar HOST_RABBITMQ para conectarse a un servicio de
         * aws y comunicarse por la web
         */
        factory.setUsername("climaco1");
        factory.setPassword("computadorgamer1");
        factory.setHost(HOST_RABBITMQ);
        factory.setPort(5671);
        try {
            factory.useSslProtocol();
        } catch (Exception e) {}
    }

    @Override
    public void publicar(Response response) throws IOException, TimeoutException {
        Gson json = new Gson();
        String jsonResponse = json.toJson(response);

        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.exchangeDeclare("logs", "fanout");
            channel.basicPublish("logs", "", null, jsonResponse.getBytes("UTF-8"));
        }
    }
}
