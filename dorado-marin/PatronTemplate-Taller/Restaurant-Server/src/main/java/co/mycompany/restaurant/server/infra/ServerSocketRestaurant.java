package co.mycompany.restaurant.server.infra;

import co.mycompany.restaurant.server.domain.services.PlatoService;
import co.unicauca.serversocket.serversockettemplate.infra.ServerSocketTemplate;
import com.google.gson.Gson;
import co.mycompany.restaurant.commons.domain.Plato;
import co.mycompany.restaurant.commons.infra.Protocol;
import co.mycompany.restaurant.commons.infra.Utilities;
import co.mycompany.restaurant.server.access.Factory;
import co.mycompany.restaurant.server.access.IPlatoRepository;

/**
 * @author Fabián David Marín - Hector Fernando Dorado
 * 
 * Esta clase envia o recibe las peticiones entre cliente y servidor, además de extender de la clase
 * serverdsockettemplate y sus metodos reescritos
 */
public class ServerSocketRestaurant extends ServerSocketTemplate{
    
    private PlatoService service;
    
    /**
     * Inicialización del serversockettemplate y la inyección de la dependencia
     * 
     * @return este mismo objeto
     */
    @Override
    protected ServerSocketTemplate init() {
        PORT = Integer.parseInt(Utilities.loadProperty("server.port"));
        IPlatoRepository repository = Factory.getInstance().getRepository();
        this.setService(new PlatoService(repository));
        return this;
    }
    
    /**
     * Metodo que procesa la solicitud de un cliente sobre un plato
     *
     * @param protocolRequest
     */
    private void processPostPlato(Protocol protocolRequest) {
        Plato plato = new Plato();
        plato.setPlatoId(protocolRequest.getParameters().get(0).getValue());
        plato.setPlatoNombre(protocolRequest.getParameters().get(1).getValue());
        plato.setPlatoPrecio(protocolRequest.getParameters().get(2).getValue());
        plato.setPlatoDescripcion(protocolRequest.getParameters().get(3).getValue());
        String response = getService().crerPlato(plato);
        respond(response);
    }
    
    /**
     * este metodo procesa la peticion que proviene del cliente
     *
     * @param requestJson de tipo json la cual contiene la petición
     */
    @Override
    protected void processRequest(String requestJson) {
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);
        switch (protocolRequest.getResource()) {
            case "restaurante":
                if (protocolRequest.getAction().equals("set")) {
                    processPostPlato(protocolRequest);
                }
                break;
        }
    }


    
     /**
     * @return the service
     */
    public PlatoService getService() {
        return service;
    }
    
    /**
     * @param service the service to set
     */
    public void setService(PlatoService service) {
        this.service = service;
    }
    
}
