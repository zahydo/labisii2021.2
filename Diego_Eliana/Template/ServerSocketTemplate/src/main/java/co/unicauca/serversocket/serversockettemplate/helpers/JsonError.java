package co.unicauca.serversocket.serversockettemplate.helpers;

/**
 *
 * @author Diego Collazos, Eliana Cerquera
 */
public class JsonError {

    /**
     * Codigo del error, Ej: 404
     */
    private String code;
    
    /**
     * Indice del error, Ej: Not_found
     */
    private String error;

    /**
     * Mensaje del error, Ej: El id de la comida no existe
     */
    private String message;

    /**
     * Constructor por defecto
     */
    public JsonError() {}

    /**
     * Constructor parametrizado
     * @param code nuevo
     * @param error nuevo
     * @param message nuevo
     */
    public JsonError(String code, String error, String message) {
        this.code = code;
        this.error = error;
        this.message = message;
    }

    /**
     * Getter de code
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter de code
     * @param code nuevo
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter del error
     * @return error
     */
    public String getError() {
        return error;
    }

    /**
     * Setter del error
     * @param error nuevo
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Getter del mensaje
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter del mensaje
     * @param message nuevo
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
