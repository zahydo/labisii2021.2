/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.layersmvc.infra;

import co.unicauca.layersmvc.utils.Constants;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 *
 * @author David E
 */
public class Publisher {
    
    private static String EXCHANGE_NAME = null;
    
    public Publisher(){
        
    }
    
    public void publish(String msg, String queue){
        
        EXCHANGE_NAME = queue;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.HOST_NAME);
        try {
            
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, Constants.EXCHANGE_TYPE);
            channel.basicPublish(EXCHANGE_NAME, "", null, msg.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + msg + "'");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
