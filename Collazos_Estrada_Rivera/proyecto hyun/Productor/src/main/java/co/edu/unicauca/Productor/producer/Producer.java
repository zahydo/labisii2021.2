
package co.edu.unicauca.Productor.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import co.edu.unicauca.Productor.utils.Constants;

public class Producer {

  private static final String EXCHANGE_NAME = "logs";
  
  
  public Producer(){
  }

  public void mandar_mensaje(String mensaje) throws Exception {
  
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost(Constants.HOST_NAME);
    
    try (Connection connection = factory.newConnection();
         Channel channel = connection.createChannel()) {
        channel.exchangeDeclare(EXCHANGE_NAME, Constants.EXCHANGE_TYPE);

        //String message = mensaje.length < 1 ? "info: Hello World!" :
          //                  String.join(" ", mensaje);
        
        String message = mensaje.isEmpty() ? "info: Hello World!" :
                            mensaje;

        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
        System.out.println(" [x] Sent '" + message + "'");
    }
  }

  public void mandar_accion(String mensaje) throws Exception {
  
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost(Constants.HOST_NAME);
    
    try (Connection connection = factory.newConnection();
         Channel channel = connection.createChannel()) {
        channel.exchangeDeclare(EXCHANGE_NAME, Constants.EXCHANGE_TYPE);

        //String message = mensaje.length < 1 ? "info: Hello World!" :
          //                  String.join(" ", mensaje);
        
        String message = mensaje.isEmpty() ? "SAVE" :
                            mensaje;

        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
        System.out.println(" [x] Sent '" + message + "'");
    }
  }
}
