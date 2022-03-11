package co.mycompany.restaurante.server.infra;

import co.mycompany.restaurante.commons.domain.Componente;
import co.mycompany.restaurante.commons.domain.DiaSemana;
import co.mycompany.restaurante.commons.domain.Restaurante;
import co.mycompany.restaurante.commons.infra.JsonError;
import co.mycompany.restaurante.commons.infra.Protocol;
import co.mycompany.restaurante.commons.infra.Utilities;
import co.mycompany.restaurante.server.access.Factory;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import co.mycompany.restaurante.server.domain.services.RestauranteService;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import co.mycompany.restaurante.commons.domain.Plato;
import co.mycompany.restaurante.commons.domain.TipoComponente;
import co.mycompany.restaurante.server.access.IRestauranteRepository;
import co.unicauca.serversocket.serversockettemplate.infra.ServerSocketTemplate;

/**
 * Servidor Socket que está escuchando permanentemente solicitudes de los
 * clientes. Cada solicitud la atiende en un hilo de ejecución
 *
 * @author Kevin Morales
 */
public class RestauranteServerSocket extends ServerSocketTemplate {

    /**
     * Servicio de clientes
     */
    private RestauranteService service;

    public RestauranteServerSocket() {
    }

    @Override
    protected void processRequest(String requestJson) {
        // Convertir la solicitud a objeto Protocol para poderlo procesar
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);

        switch (protocolRequest.getResource()) {
            case "componente":
                processSetComponente(protocolRequest);
                break;
            case "restaurantes":
                if (protocolRequest.getAction().equals("get")) {
                    // Obtener datos de restaurante
                    processGetRestaurantes();
                }
                break;
            case "componentes":
                if (protocolRequest.getAction().equals("getMenu")) {
                    //{"resource":"componentes","action":"get","parameters":[{"name":"rest_id","value":"1"},{"name":"dia","value":"LUNES"}]}
                    processGetMenuComponentes(protocolRequest);
                } else if (protocolRequest.getAction().equals("get")) {
                    processGetComponentes();
                }

                break;
            case "administrador":
                processGetAdministrador(protocolRequest);
                break;
            case "plato":
                if (protocolRequest.getAction().equals("get")) {
                    processGetPlato(protocolRequest);
                } else if (protocolRequest.getAction().equals("update")) {
                    processUpdatePlato(protocolRequest);
                }

                break;
            case "componenteSemanal":
                if (protocolRequest.getAction().equals("delete")) {
                    processDeleteComponenteSemanal(protocolRequest);
                } else if (protocolRequest.getAction().equals("set")) {
                    processSetComponenteSemanal(protocolRequest);
                }
        }

    }

    /**
     * Procesa la solicitud de agregar un Componente
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processUpdatePlato(Protocol protocolRequest) {
        //Protocol{resource=componente, action=set, 
        //parameters=[Parameter{name=Id, value=12}, Parameter{name=Nombre, value=jugo de lulo}, Parameter{name=Tipo, value=BEBIDA}]}
        Plato plato = new Plato();
        int cont = 0;
        int idRestaurante = Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue());
        plato.setId(Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue()));
        plato.setDescripcion(protocolRequest.getParameters().get(cont++).getValue());
        plato.setPrecio(Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue()));
        plato.setCantidad(Integer.parseInt(protocolRequest.getParameters().get(cont).getValue()));
        String response = service.updatePlato(idRestaurante, plato);
        respond(response);
    }

    /**
     * Procesa la solicitud de agregar un Componente
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processSetComponenteSemanal(Protocol protocolRequest) {
        //Protocol{resource=componente, action=set, 
        //parameters=[Parameter{name=Id, value=12}, Parameter{name=Nombre, value=jugo de lulo}, Parameter{name=Tipo, value=BEBIDA}]}
        Componente componente = new Componente();
        int cont = 0;
        int idRestaurante = Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue());
        DiaSemana dia = DiaSemana.valueOf(protocolRequest.getParameters().get(cont++).getValue());
        componente.setId(Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue()));

        componente.setNombre(protocolRequest.getParameters().get(cont++).getValue());

        componente.setTipo(TipoComponente.valueOf(protocolRequest.getParameters().get(cont).getValue()));
        String response = service.addComponenteSemanal(idRestaurante, componente, dia);
        respond(response);
    }

    /**
     * Procesa la solicitud de agregar un Componente
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processDeleteComponenteSemanal(Protocol protocolRequest) {
        //Protocol{resource=componenteSemanal, action=delete, 
        //parameters=[Parameter{name=Id, value=12}, Parameter{name=Nombre, value=jugo de lulo}, Parameter{name=Tipo, value=BEBIDA}]}
        Componente componente = new Componente();
        int cont = 0;
        int idRestaurante = Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue());
        DiaSemana dia = DiaSemana.valueOf(protocolRequest.getParameters().get(cont++).getValue());
        componente.setId(Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue()));

        componente.setNombre(protocolRequest.getParameters().get(cont++).getValue());

        componente.setTipo(TipoComponente.valueOf(protocolRequest.getParameters().get(cont).getValue()));
        String response = service.deleteComponenteSemanal(idRestaurante, componente, dia);
        respond(response);
    }

    /**
     * Procesa la solicitud de agregar un Componente
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetComponentes() {
        ArrayList<Componente> componentes = service.getComponentes();
        String response = objectToJSON(componentes);
        respond(response);
    }

    /**
     * Procesa la solicitud de agregar un Componente
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetMenuComponentes(Protocol protocolRequest) {
        ArrayList<Componente> componentes = service.getMenuComponentes(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()), DiaSemana.valueOf(protocolRequest.getParameters().get(1).getValue()));
        String response = objectToJSON(componentes);
        respond(response);
    }



    private void processGetPlato(Protocol protocolRequest) {
        Plato plato = service.getPlato(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        String response = objectToJSON(plato);
        respond(response);
    }

    private void processGetAdministrador(Protocol protocolRequest) {
        String clave = service.getAdministrador(protocolRequest.getParameters().get(0).getValue());
        respond(clave);

    }

    /**
     * Procesa la solicitud de agregar un Componente
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processSetComponente(Protocol protocolRequest) {
        //Protocol{resource=componente, action=set, 
        //parameters=[Parameter{name=Id, value=12}, Parameter{name=Nombre, value=jugo de lulo}, Parameter{name=Tipo, value=BEBIDA}]}
        Componente componente = new Componente();
        int cont = 0;
        componente.setId(Integer.parseInt(protocolRequest.getParameters().get(cont).getValue()));
        cont++;
        componente.setNombre(protocolRequest.getParameters().get(cont).getValue());
        cont++;
        componente.setTipo(TipoComponente.valueOf(protocolRequest.getParameters().get(cont).getValue()));
        String response = service.addComponente(componente);
               respond(response);

    }

    private void processGetRestaurantes() {
        ArrayList<Restaurante> Restaurantes = service.getRestaurantes();
        if (Restaurantes.isEmpty()) {
           String errorJson = "Restaurante vacio";
            respond(errorJson);
        } else {
            respond(objectToJSON(Restaurantes));
        }
    }

    /**
     * @return the service
     */
    public RestauranteService getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(RestauranteService service) {
        this.service = service;
    }

    @Override
    protected ServerSocketTemplate init() {
        PORT = Integer.parseInt(Utilities.loadProperty("server.port"));
        // Se hace la inyección de dependencia
        IRestauranteRepository repository = Factory.getInstance().getRepository();
        this.setService(new RestauranteService(repository));
        return this;
    }
}
