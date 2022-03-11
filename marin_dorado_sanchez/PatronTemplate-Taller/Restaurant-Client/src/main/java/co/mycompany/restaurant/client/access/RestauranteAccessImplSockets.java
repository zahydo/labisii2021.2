
package co.mycompany.restaurant.client.access;

import co.mycompany.restaurant.client.infra.RestaurantSocket;
import co.mycompany.restaurant.commons.domain.Plato;
import co.mycompany.restaurant.commons.infra.JsonError;
import co.mycompany.restaurant.commons.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Fabián David Marín - Hector Fernando Dorado - Juan Sebastian Sanchez
 * 
 * Este servicio permite gestionar los platos que son peticiones del serversocket
 */
public class RestauranteAccessImplSockets implements IRestaurantAccess{

    private RestaurantSocket mySocket;

    public RestauranteAccessImplSockets() {
        mySocket = new RestaurantSocket();
    }
    
    /**
     * Crea la petición en formato Json y se envia al socket
     *
     * @param plato objeto de tipo Plato
     * @return retorna la peticion en formato Json
     */
    private String AgregarPlatoRequestJson(Plato plato) {
        Protocol protocol = new Protocol();
        protocol.setResource("restaurante");
        protocol.setAction("set");
        protocol.addParameter("Id del Plato", plato.getPlatoId());
        protocol.addParameter("Nombre Plato", plato.getPlatoNombre());
        protocol.addParameter("Precio Plato", plato.getPlatoPrecio());
        protocol.addParameter("Descripción Plato", plato.getPlatoDescripcion());
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }
    
        /**
     * extrae los mensajes de errores provenientes de uan lista
     * 
     * @param jsonResponse lista 
     * @return cada mensaje de error
     */
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }
    
    /**
     * Método que agrega un plato
     * @param plato objeto tipo plato
     * @return retorna una cadena con el nombre del plato agregado
     * @throws Exception error 
     */
    
    @Override
    public String AgregarPlato(Plato plato) throws Exception {
        String jsonResponse = null;
        String requestJson = AgregarPlatoRequestJson(plato);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(RestauranteAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(RestauranteAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Se agregaron los platos, retorna el nombre de ellos
                return jsonResponse;
            }
        }
    }
    
    /**
     * Convierte el jsonError a un array de objetos jsonError
     * 
     * @param jsonError
     * @return objeto MyError
     */
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }
}
