package co.unicauca.foodapp.commons.infra;

import java.util.ArrayList;
import java.util.List;

/**
 * Protocolo de comunicación entre la aplicación cliente y el servidor
 *
 * @author Diego Collazos, Eliana Cerquera
 */
public class Protocol {

    /**
     * Atributo nombre del recurso
     */
    private String resource;

    /**
     * Atributo tipo de accion
     */
    private String action;

    /**
     * Atributo lista de parametros
     */
    private List<Parameter> parameters;

    /**
     * Constructor por defecto
     */
    public Protocol() {
        parameters = new ArrayList<>();
    }

    /**
     * Getter del recurso
     * @return resource
     */
    public String getResource() {
        return resource;
    }

    /**
     * Setter del recurso
     * @param resource nuevo
     */
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * Getter de la accion
     * @return action
     */
    public String getAction() {
        return action;
    }

    /**
     * Setter de la accion
     * @param action nuevo
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * Getter de los parametros
     * @return parameters
     */
    public List<Parameter> getParameters() {
        return parameters;
    }

    /**
     * Setter de los parametros
     * @param parameters lista de nuevos parametros
     */
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    /**
     * Agrega un parametro a la lista
     * @param name del nuevo parametro
     * @param value del nuevo parametro
     */
    public void addParameter(String name, String value) {
        parameters.add(new Parameter(name, value));
    }
}