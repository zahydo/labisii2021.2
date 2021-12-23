package co.edu.unicauca.layersmvc.infra;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


public class Publicador {
    private static final String EXCHANGE_NAME = "logs";

    public void Publicar(String cadenaGson) throws IOException, TimeoutException{
    ConnectionFactory factory = new ConnectionFactory();
    //factory.setHost("localhost");

    factory.setUsername("climaco1");
    factory.setPassword("computadorgamer1");
    factory.setHost("b-132dd872-4555-48c5-a7e6-b6352d232e3b.mq.us-east-2.amazonaws.com");
    factory.setPort(5671);
    try {
        factory.useSslProtocol();
    } catch (Exception e) {
    }

    try (Connection connection = factory.newConnection();
         Channel channel = connection.createChannel()) {
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        //String message = argv.length < 1 ? "info: Hello World!" :
        String message = cadenaGson;
        //String.join(" ", argv);

        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
        System.out.println(" [x] Sent '" + message + "'");
    }
}
}
