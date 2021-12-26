/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.layersmvc.infra;

import co.edu.unicauca.layersmvc.domain.Product;
import co.edu.unicauca.layersmvc.domain.service.ServiceModel;
import com.google.gson.Gson;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XssIsor
 */
public class RabbitPublisher implements IPublisher{
    
    private static String QUEUE_NAME = "products";
    private static String EXCHANGE_TYPE = "fanout";
    ServiceModel service;
    
    
    public RabbitPublisher(){};

    @Override
    public void publish(Product product) {
        
        Gson gson = new Gson();
        String message = gson.toJson(product);
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Utilities.HOST);
        try {
            com.rabbitmq.client.Connection connection = factory.newConnection();
            com.rabbitmq.client.Channel channel = connection.createChannel();
            channel.exchangeDeclare(QUEUE_NAME, EXCHANGE_TYPE);
            channel.basicPublish(QUEUE_NAME, "", null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");
        } catch(IOException | TimeoutException ex) {
            Logger.getLogger(RabbitPublisher.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    
}
