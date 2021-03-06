package co.edu.unicauca.layersmvc.infra;

import co.edu.unicauca.layersmvc.domain.Product;
import co.edu.unicauca.layersmvc.domain.ProductAction;
import co.edu.unicauca.layersmvc.domain.service.ServiceModel;
import co.edu.unicauca.layersmvc.presentation.GUIListProductOtherViewController;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Delivery;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class RabbitMQConsumer {

    private final static String QUEUE_NAME = "layers-mvc";
    public static final String QUEUE_HOST = "localhost";
    private final Gson gson;
    public ServiceModel model;
    public RabbitMQConsumer(ServiceModel model) {
        gson = new Gson();
        this.model = model;
    }

    public void consume() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(QUEUE_HOST);
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare("LOGS", "fanout");
            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, "LOGS", "");

            //channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for messages");

            channel.basicConsume(queueName, true, this::processMessage, consumerTag -> {
            });
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }

    }

    private void processMessage(String consumerTag, Delivery delivery) {
        String serializedMessage = new String(delivery.getBody(), StandardCharsets.UTF_8);
        ProductMessage productMessage = gson.fromJson(serializedMessage, ProductMessage.class);
        Product product = productMessage.getProduct();
        ProductAction productAction = productMessage.getAction();     
        System.out.println("Received[x]" + product.getName());
        Product newProduct = new Product(product.getProductId(), product.getName(), product.getPrice());
        if(productAction.toString().equals("SAVE")) {
        	model.saveProduct(newProduct);
            GUIListProductOtherViewController view = new GUIListProductOtherViewController(model);
            view.setVisible(true);
        }else {
        	if(productAction.toString().equals("EDIT")) {
        		model.updateProduct(newProduct,model);
        		
        	}
        }
        


        //service.saveProduct(newProduct);
        
    }

}