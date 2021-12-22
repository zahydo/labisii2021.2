package co.edu.unicauca.layersmvc.infra;

import co.edu.unicauca.layersmvc.domain.Response;
import co.edu.unicauca.layersmvc.domain.service.ServiceModel;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author artur
 */
public class RabbitController {

    private static String HOST_RABBITMQ = "b-eccdea82-2c7f-4fd2-a90b-a689482b8c09.mq.us-east-2.amazonaws.com";
    private static String HOST_RABBITMQ_LOCAL = "localhost";
    private String EXCHANGE_NAME = "logs";
    ServiceModel model;
    ConnectionFactory factory;
    String IP;
    Connection connection;
    Channel channel;
    String queueName;
    Gson json;

    public RabbitController(String IP) throws IOException, TimeoutException {
        model = new ServiceModel();
        // this.IP = IP;
        this.factory = new ConnectionFactory();
        /*
        quitar los comentarios y usar HOST_RABBITMQ para conectarse a un servicio de aws y comunicarse por la web
        */
        // factory.setUsername("climaco1");
        // factory.setPassword("computadorgamer1");
        factory.setHost(HOST_RABBITMQ_LOCAL);
        // factory.setPort(5671);
        // try {
        //   factory.useSslProtocol();
        // } catch (Exception e) {
        // }
        // factory.setHost(IP);
        connection = factory.newConnection();
        channel = connection.createChannel();
    }

    public void configChannel() throws IOException {
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "");
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
    }

    public void processRequest(String requestJson) {
        json = new Gson();
        Response response = json.fromJson(requestJson, Response.class);

        switch (response.getTipo()) {
            case "post":
                model.saveProduct(response.getProducto());
                break;
            case "update":
                model.updateProduct(response.getProducto());
                break;
        }
    }

    public String getEXCHANGE_NAME() {
        return EXCHANGE_NAME;
    }

    public ServiceModel getModel() {
        return model;
    }

    public ConnectionFactory getFactory() {
        return factory;
    }

    public String getIP() {
        return IP;
    }

    public Connection getConnection() {
        return connection;
    }

    public Channel getChannel() {
        return channel;
    }

    public String getQueueName() {
        return queueName;
    }

    public Gson getJson() {
        return json;
    }

    public void setEXCHANGE_NAME(String EXCHANGE_NAME) {
        this.EXCHANGE_NAME = EXCHANGE_NAME;
    }

    public void setModel(ServiceModel model) {
        this.model = model;
    }

    public void setFactory(ConnectionFactory factory) {
        this.factory = factory;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public void setJson(Gson json) {
        this.json = json;
    }

}
