
package co.edu.unicauca.Subscriptor1.subscriber;

import com.google.gson.JsonObject;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import co.edu.unicauca.Subscriptor1.access.ProductRepository;
import co.edu.unicauca.Subscriptor1.domain.service.ServiceModel;
import co.edu.unicauca.Subscriptor1.utils.Constants;
import co.edu.unicauca.Subscriptor1.utils.Json;

public class Subscriptor {
  private static final String EXCHANGE_NAME = "logs";
  private String message = "";
  private JsonObject producto;

  private Json json = new Json();
  private ServiceModel servicio;
  
  public Subscriptor(){
      message = "";
  }
  public Subscriptor(ServiceModel servicio){
    message = "";
    this.servicio = servicio;
}

  public void recibir_mensaje() throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost(Constants.HOST_NAME);
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.exchangeDeclare(EXCHANGE_NAME, Constants.EXCHANGE_TYPE);
    String queueName = channel.queueDeclare().getQueue();
    channel.queueBind(queueName, EXCHANGE_NAME, "");

    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        message = new String(delivery.getBody(), "UTF-8");
        if(message.equals("SAVE")){
          System.out.println(" [x] Received '" + message + "'");
        }else if(message.equals("MOD")){
          System.out.println(" [x] Received '" + message + "'");
        }else{
          producto = json.comvertirString_Json(message);
          servicio.saveProduct(producto);
          //System.out.println(producto);
        }
        
        
    };
    
    
    
    channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    
  }

  public String getMessage() {
      return message;
  }

  public JsonObject getJson(){
    return producto;
  }
  
  
}