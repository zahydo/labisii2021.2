package co.edu.unicauca.layersmvc.infra;

import co.edu.unicauca.layersmvc.rabbitmq.utils.Constants;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RabbitMQPublisher implements IPublisher {
    
    
    private final String EXCHANGE_NAME = "logs";
    private ConnectionFactory factory; 
    private Channel channel ; 
    private Connection connection; 
   
    public RabbitMQPublisher() {
        factory = new ConnectionFactory();
        factory.setHost(Constants.HOST_NAME);
        try{
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, Constants.EXCHANGE_TYPE);
        } catch (IOException | TimeoutException ex) {
            Logger.getLogger(RabbitMQPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void publish(String message) {
        try {
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(RabbitMQPublisher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RabbitMQPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
