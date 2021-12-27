/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.layersmvc.infra;

import co.edu.unicauca.layersmvc.domain.Product;
import co.edu.unicauca.layersmvc.domain.service.ServiceMemory;
import co.edu.unicauca.layersmvc.domain.service.ServiceModel;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XssIsor
 */
public class RabbitSubscriber implements Runnable{
    
    private static String EXCHANGE_NAME = "products";
    private static String EXCHANGE_TYPE = "fanout";
    ServiceMemory service = new ServiceMemory();
    Channel channel;
    String qName = "";
    

    public RabbitSubscriber() {
        
        try {
             ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Utilities.HOST);
        Connection connection = factory.newConnection();
        channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);
        qName = channel.queueDeclare().getQueue();
        } catch (Exception e) {
            System.out.println("Se lanzó la excepción " + e.getMessage());
        }
    
        
    }

    @Override
    public void run() {
        try {
            channel.queueBind(qName, EXCHANGE_NAME, "");
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            
            Gson gson = new Gson();
            final Product gsonProduct = gson.fromJson(message, Product.class);
            
            System.out.println(" [*] Message Recived " + message);
            
            if(gsonProduct.getActionType().equals("Guardar")){
                this.service.add(gsonProduct);
            }else{
                this.service.update(gsonProduct);
            }
            for(Product product: service.getProductRepo()){
                System.out.println("Lista de productos: " + product.getName());
            }
            
        };
            channel.basicConsume(qName, true, deliverCallback, consumerTag -> {
            });
        } catch (IOException ex) {
            Logger.getLogger(RabbitSubscriber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
