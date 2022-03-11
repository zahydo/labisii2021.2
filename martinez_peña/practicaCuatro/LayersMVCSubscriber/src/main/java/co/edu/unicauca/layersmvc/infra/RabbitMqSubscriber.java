/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.layersmvc.infra;

import co.edu.unicauca.layersmvc.access.ISubscriber;
import co.edu.unicauca.layersmvc.domain.Product;
import co.edu.unicauca.layersmvc.domain.service.ServiceModel;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 *
 * @author 57322
 */
public class RabbitMqSubscriber implements ISubscriber {

    private static final String EXCHANGE_NAME = "layers";
    ServiceModel service = new ServiceModel();

    @Override
    public void Subscriber() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.HOST_NAME);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, Constants.EXCHANGE_TYPE);
        String queueName = channel.queueDeclare().getQueue();
        //Enlace entre la cola y el intercambio
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");

            Gson gson = new Gson();
            final Product producto = gson.fromJson(message, Product.class);
            this.realizarAccion(producto);
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }

    public boolean realizarAccion(Product producto) {
        if (producto.getAccion().equals("add")) {
            this.service.saveProduct(producto);
        } else {
            this.service.updateProduct(producto);
        }
        return true;
    }

}
