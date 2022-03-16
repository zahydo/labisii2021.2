
package co.unicauca.restaurant.client.infra;

import co.unicauca.restaurant.commons.infra.Utilities;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anderson Diaz
 */
public class RestaurantSocket {

    private java.net.Socket socket = null;

    private Scanner input;

    private PrintStream output;

    private final String IP_SERVER = Utilities.loadProperty("server.ip");

    private final int PORT = Integer.parseInt(Utilities.loadProperty("server.port"));


    public String sendStream(String requestJson) throws IOException {
        String response = "";
        input = new Scanner(socket.getInputStream());
        output = new PrintStream(socket.getOutputStream());
        output.flush();


        output.println(requestJson);


        if (input.hasNextLine()) {
            response = input.nextLine();
        }
        return response;
    }


    public void closeStream() {
        output.close();
        input.close();
    }

    public void connect() throws IOException {
        socket = new java.net.Socket(IP_SERVER, PORT);
        Logger.getLogger("SocketClient").log(Level.INFO, "Socket establecido");
    }

    public void disconnect() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(RestaurantSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
