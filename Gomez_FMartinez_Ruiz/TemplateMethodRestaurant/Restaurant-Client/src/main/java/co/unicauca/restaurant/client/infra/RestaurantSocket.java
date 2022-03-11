package co.unicauca.restaurant.client.infra;


import co.unicauca.restaurant.commons.infra.Utilities;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Establece la lógica de conexión del socket cliente
 * @author XssIsor
 */
public class RestaurantSocket {
    
    /**
    * Ip del socket del server.
    */
    private final String IP = Utilities.loadProperty("server.ip");
    
    /**
    * Puerto del socket del server.
    */
    private final int PORT = Integer.parseInt(Utilities.loadProperty("server.port"));
    
    /**
    * Socket para el cliente.
    */
    private java.net.Socket socket = null;
    
    /**
    * Stream de salida del socket cliente.
    */
    private PrintStream outputRequest;
    
    /**
    * Stream de entrada del socket cliente.
    */
    private Scanner inputRequest;
   
   

    /**
    * Manda una solicitud al server desde el socket.
    * @param requestJson String. Solicitud a enviar en formato JSon.
    * @return response String. Respuesta del socket
    * @throws IOException . Excepción en caso de error en la entrada o la salida.
    */
    public String sendStream(String requestJson) throws IOException {
        
        String response = "";
        inputRequest = new Scanner(socket.getInputStream());
        outputRequest = new PrintStream(socket.getOutputStream());
        outputRequest.flush();

        outputRequest.println(requestJson);

        if (inputRequest.hasNextLine()) {
            response = inputRequest.nextLine();
        }
        return response;
    }
    
    /**
     * Desconecta el socket.
     */
    public void disconnect() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(RestaurantSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cierra los streams de salida y entrada.
     */
    public void closeStream() {
        inputRequest.close();
        outputRequest.close();
    }

    

    /**
     * Conectar el socket cliente al server.
     * @throws IOException error de entrada y salida
     */
    public void connect() throws IOException {
        socket = new java.net.Socket(IP, PORT);
        Logger.getLogger("SocketClient").log(Level.INFO, "Conexión Socket existosa");
    }
}
