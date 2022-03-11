package co.mycompany.restaurant.client.infra;

import co.mycompany.restaurant.commons.infra.Utilities;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Fabián David Marín - Hector Fernando Dorado
 * 
 * Esta clase tiene como función enviar solicitudes y recibir respuestas de estas 
 * entre el cliente y el servidor
 */
public class RestaurantSocket {

    /**
     * Socket de clientes
     */
    private java.net.Socket socket = null;
    /**
     * Recibe la respuesta del socket
     */
    private Scanner input;
    /**
     * Envia la solicitud por el socket
     */
    private PrintStream output;
    /**
     * Ip del Server
     */
    private final String IP_SERVER = Utilities.loadProperty("server.ip");
    /**
     * Puerto del server socket
     */
    private final int PORT = Integer.parseInt(Utilities.loadProperty("server.port"));

    /**
     * Envia una solicitud desde el cliente al servidor mediate el socket
     *
     * @param requestJson Solicitud de tipo json
     * @return Respuesta del socket
     * @throws IOException errores 
     */
    public String sendStream(String requestJson) throws IOException {
        String response = "";
        input = new Scanner(socket.getInputStream());
        output = new PrintStream(socket.getOutputStream());
        output.flush();

        // Enviar la solicitud
        output.println(requestJson);

        // Procesa la respuesta
        if (input.hasNextLine()) {
            response = input.nextLine();
        }
        return response;
    }

    /**
     * Cierra los flujos input y output
     */
    public void closeStream() {
        output.close();
        input.close();
    }

    /**
     * Desconecta el socket
     */
    public void disconnect() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(RestaurantSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Conecta un socket
     *
     * @throws IOException error de imput o output
     */
    public void connect() throws IOException {
        socket = new java.net.Socket(IP_SERVER, PORT);
        Logger.getLogger("SocketClient").log(Level.INFO, "Socket establecido");
    }

}
