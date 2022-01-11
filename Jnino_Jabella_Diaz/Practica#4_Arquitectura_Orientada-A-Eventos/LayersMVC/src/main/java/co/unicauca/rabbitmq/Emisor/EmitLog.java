
package co.unicauca.rabbitmq.Emisor;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import co.unicauca.rabbitmq.utils.Constants;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class EmitLog {

  private static final String EXCHANGE_NAME = "logs";
   
  public static void Publish(String prmMsj) throws IOException, TimeoutException{
      ConnectionFactory factory = new ConnectionFactory();
       factory.setHost(Constants.HOST_NAME);
         try (Connection connection = factory.newConnection();
         Channel channel = connection.createChannel()) {
        channel.exchangeDeclare(EXCHANGE_NAME, Constants.EXCHANGE_TYPE);

        channel.basicPublish(EXCHANGE_NAME, "", null, prmMsj.getBytes("UTF-8"));
        System.out.println(" [x] Sent '" + prmMsj + "'");
  }
  }
}

