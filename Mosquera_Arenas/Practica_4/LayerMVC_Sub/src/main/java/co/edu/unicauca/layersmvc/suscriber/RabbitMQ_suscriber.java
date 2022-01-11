/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.layersmvc.suscriber;

import co.edu.unicauca.layersmvc.utils.Constants;
import co.edu.unicauca.layersmvc.access.IProductRepository;
import co.edu.unicauca.layersmvc.service.Servicio;
import co.unicauca.layersmvc.commons.Product_protocol;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 *
 * @author David E
 */
public class RabbitMQ_suscriber implements ISuscriber{

    private IProductRepository repositorio;
    private static final String EXCHANGE_NAME = "logs";
    private static ConnectionFactory factory;
    private static Connection connection;
    private static Channel channel;
    
    public RabbitMQ_suscriber(IProductRepository repositorio){
        this.repositorio = repositorio;
        init();
    }
    
    private void init(){
        try {
            factory = new ConnectionFactory();
            factory.setHost(Constants.HOST_NAME);
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, Constants.EXCHANGE_TYPE);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    
    @Override
    public void receive() {
        try {
            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, EXCHANGE_NAME, "");

            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                Product_protocol protocolP = transformar(message);
                Servicio srv = new Servicio(repositorio);
                srv.actionRepository(protocolP);
            };

            channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    private static Product_protocol transformar(String mensaje){
        Gson gson = new Gson();
        Product_protocol envp = gson.fromJson(mensaje,Product_protocol.class);
        return envp;
    }
    
}
