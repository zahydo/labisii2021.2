package practica.main;

import practica.baseDatos.DataBase;
import practica.logica.RabbitMQConsumer;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
    	DataBase mongoConnection = new DataBase();
        mongoConnection.crearConexion();
    	RabbitMQConsumer consumer = new RabbitMQConsumer(mongoConnection);
        consumer.consume();
    }
}
