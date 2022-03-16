/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.client.infra;

import co.unicauca.restaurant.commons.infra.Utilities;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Libardo, Julio
 */
public class Conexion_Restaurante {

    private java.net.Socket socket = null;

    private Scanner input;

    private PrintStream output;

    private final String IP_SERVER = Utilities.loadProperty("server.ip");

    private final int PORT = Integer.parseInt(Utilities.loadProperty("server.port"));

    public String EnviarSeñal(String requestJson) throws IOException {
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

    public void CerrarSeñal() {
        output.close();
        input.close();
    }

    public void Desconectar() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Conexion_Restaurante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Conectar() throws IOException {
        socket = new java.net.Socket(IP_SERVER, PORT);
        Logger.getLogger("SocketClient").log(Level.INFO, "Socket establecido");
    }
}
