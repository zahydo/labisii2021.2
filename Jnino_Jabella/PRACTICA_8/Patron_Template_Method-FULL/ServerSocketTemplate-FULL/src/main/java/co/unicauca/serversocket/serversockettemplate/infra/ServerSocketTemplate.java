package co.unicauca.serversocket.serversockettemplate.infra;

import co.unicauca.serversocket.serversockettemplate.helpers.JsonError;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Julio Hurtado, Libardo Pantoja
 */
public abstract class ServerSocketTemplate implements Runnable {

   
    private static ServerSocket ssock;

    private static Socket atrSockerPeticion;
    
    private Scanner input;
   
    
    private PrintStream output;
   
    /*
    puerto de escucha socket
    */
    protected static int PORT;

    protected abstract ServerSocketTemplate init();

    protected abstract void processRequest(String request);

    /**
     * Arranca el servidor y hace la estructura completa
     */
    public void startServer() {
        init();
        openPort();
        while (true) {
            waitToClient();
            throwThread();
        }
    }

    /**
     * Abre el puerto
     */
    private void openPort() {
        try {
            ssock = new ServerSocket(PORT);
            Logger.getLogger("Server").log(Level.INFO, "Servidor iniciado, escuchando por el puerto {0}", PORT);
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error del server socket al abrir el puerto", ex);
        }
    }

    private void waitToClient() {
        try {
            atrSockerPeticion = ssock.accept();
            Logger.getLogger("Socket").log(Level.INFO, "Socket conectado");
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Eror al abrir un socket", ex);
        }
    }

    /**
     * Lanza el hilo
     */
    private void throwThread() {
        try {
            new Thread(((ServerSocketTemplate) this.getClass().newInstance()).init()).start();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cuerpo del hilo
     */
    @Override
    public void run() {
        try {
            createStreams();
            readStream();
            closeStream();

        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Eror al leer el flujo", ex);
        }
    }

    /**
     * Crea los flujos con el atrSockerPeticion
     *
     * @throws IOException
     */
    private void createStreams() throws IOException {
        output = new PrintStream(atrSockerPeticion.getOutputStream());
        input = new Scanner(atrSockerPeticion.getInputStream());
    }

    /**
     * Lee el flujo del atrSockerPeticion
     */
    private void readStream() {
        if (input.hasNextLine()) {
            // Extrae el flujo que envi?? la aplicaci??n cliente
            String request = input.nextLine();
            processRequest(request);

        } else {
            output.flush();
            String errorJson = generateErrorJson();
            output.println(errorJson);
        }
    }

    /**
     * Cierra los flujos de entrada y salida
     *
     * @throws IOException
     */
    private void closeStream() throws IOException {
        output.close();
        input.close();
        atrSockerPeticion.close();
    }

    /**
     * Genera un ErrorJson
     *
     * @return error en formato json
     */
    private String generateErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("400");
        error.setError("BAD_REQUEST");
        error.setMessage("Error en la solicitud");
        errors.add(error);

        Gson gson = new Gson();
        String errorJson = gson.toJson(errors);

        return errorJson;
    }

    /**
     * Convierte el objeto Customer a json para que el servidor lo envie como
 respuesta por el atrSockerPeticion
     *
     * @param customer cliente
     * @return customer en formato json
     */
    protected String objectToJSON(Object customer) {
        Gson gson = new Gson();
        String strObject = gson.toJson(customer);
        return strObject;
    }

    protected void respond(String response) {
        output.println(response);
    }
}
