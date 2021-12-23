
package com.mycompany.subscriber.infra;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import com.mycompany.subscriber.utils.Constants; 
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RabbitMQSubscriber implements Runnable {
  private static final String EXCHANGE_NAME = "logs";
  private ISubscriber myOffice; 
  private ConnectionFactory factory; 
  private Connection connection; 
  private Channel channel; 
  private String queueName;  
  
  public RabbitMQSubscriber(ISubscriber myOffice){
      try {
          this.myOffice = myOffice;
          factory = new ConnectionFactory();
          factory.setHost(Constants.HOST_NAME);
          connection = factory.newConnection();
          channel = connection.createChannel();
          channel.exchangeDeclare(EXCHANGE_NAME, Constants.EXCHANGE_TYPE);
          queueName = channel.queueDeclare().getQueue();
      } catch (IOException | TimeoutException ex) {
          Logger.getLogger(RabbitMQSubscriber.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
  @Override
  public void run() {
    try{
        channel.queueBind(queueName, EXCHANGE_NAME, "");
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            myOffice.onMessage(message);
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    }catch (IOException ex) {
        Logger.getLogger(RabbitMQSubscriber.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
} 




