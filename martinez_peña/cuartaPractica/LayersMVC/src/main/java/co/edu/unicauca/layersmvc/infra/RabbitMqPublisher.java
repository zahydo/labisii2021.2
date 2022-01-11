/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.layersmvc.infra;

import co.edu.unicauca.layersmvc.access.IPublisher;
import co.edu.unicauca.layersmvc.domain.Product;
import co.edu.unicauca.layersmvc.domain.service.ServiceModel;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 *
 * @author 57322
 */
public class RabbitMqPublisher implements IPublisher {

    ServiceModel service;

    //Constructor
    public RabbitMqPublisher(ServiceModel service) {
        this.service = service;
    }

    private static final String EXCHANGE_NAME = "layers";

    RabbitMqPublisher() {
    }

    @Override
    public void Publish(Product producto, String accion) throws Exception {

        Gson gson = new Gson();
        JsonObject ObjectMessage = (JsonObject) gson.toJsonTree(producto);
        ObjectMessage.addProperty("accion", accion);
        String message = ObjectMessage.toString();
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.HOST_NAME);
        try ( Connection connection = factory.newConnection();  Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, Constants.EXCHANGE_TYPE);
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
