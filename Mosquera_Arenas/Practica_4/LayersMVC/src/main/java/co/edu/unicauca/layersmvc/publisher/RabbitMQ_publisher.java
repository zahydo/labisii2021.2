/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.layersmvc.publisher;

import co.unicauca.layersmvc.commons.Product_protocol;
import co.unicauca.layersmvc.utils.Constants;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 *
 * @author David E
 */
public class RabbitMQ_publisher implements IPublisher{
    
    private static String EXCHANGE_NAME;
    private static ConnectionFactory factory;
    private static Connection connection;
    private static Channel channel;
    
    public RabbitMQ_publisher(String queue){
        init(queue);
    }
    
    public void init(String queue){
        EXCHANGE_NAME = queue;
        
        factory = new ConnectionFactory();
        factory.setHost(Constants.HOST_NAME);
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, Constants.EXCHANGE_TYPE);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
    }
    
    @Override
    public void publish(Product_protocol env_p){
        Gson gson = new Gson();
        String msgJson = gson.toJson(env_p);
        
        
        try {
            channel.basicPublish(EXCHANGE_NAME, "", null, msgJson.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + msgJson + "'");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
