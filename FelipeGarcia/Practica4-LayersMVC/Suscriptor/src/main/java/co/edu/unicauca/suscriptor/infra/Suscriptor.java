/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.suscriptor.infra;

import co.edu.unicauca.suscriptor.domain.service.ServiceModel;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author user
 */
public class Suscriptor {
    
    private static final String EXCHANGE_NAME = "logs";
    
    public void onMessage() throws IOException, TimeoutException {
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
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "");
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            String tipo;
            message = message.replace("'", "");
            tipo = message.split("-")[0];
            message = "'" + message.split("-")[1] + "'";
            System.out.println(message);
//            ServiceModel service = new ServiceModel();
//            if (tipo.compareTo("post") == 0) {
//                service.save(message);
//            } else {
//                service.update(message);
//            }
            
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
        
    }
    
}
