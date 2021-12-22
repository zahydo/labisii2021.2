/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.unicauca.subscriber.LayersMVC;


import basededatos.ProductMysql;
import co.unicauca.layersmvc.commons.EnviarProducto;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;


/**
 *
 * @author Sebastian_Arenas
 */

public class Consola {

    private static final String EXCHANGE_NAME = "logs";

public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost(Constants.HOST_NAME);
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.exchangeDeclare(EXCHANGE_NAME, Constants.EXCHANGE_TYPE);
    String queueName = channel.queueDeclare().getQueue();
    channel.queueBind(queueName, EXCHANGE_NAME, "");

    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
    
    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        String message = new String(delivery.getBody(), "UTF-8");
        System.out.println(" [x] Received '" + message + "'");
        aux(message);
    };
    
    channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
  }

  public static void aux (String message){
      Gson gson = new Gson();
      EnviarProducto envp = gson.fromJson(message,EnviarProducto.class);
      System.out.println(envp.getProducto().getName());
      
      ProductMysql repositorio = new ProductMysql();
      
      if (envp.getAccion().equals("save")){
          repositorio.createProduct(envp.getProducto());
      }else if(envp.getAccion().equals("update")){
          repositorio.update(envp.getProducto());
      }
      
      
  }
}
