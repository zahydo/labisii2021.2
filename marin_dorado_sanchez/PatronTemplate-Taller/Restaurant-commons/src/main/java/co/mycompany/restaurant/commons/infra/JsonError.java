package co.mycompany.restaurant.commons.infra;

/**
 * @author Fabián David Marín - Hector Fernando Dorado - Juan Sebastian Sanchez
 * 
 *  Representa un error en el json
 */
public class JsonError {

    /**
     * Ej. 404
     */
    private String code;
    /**
     * Ej. Not_found
     */
    private String error;
    /**
     * Ej. La cédula del cliente no existe
     */
    private String message;
    /**
     * Constructor por defecto
     */
    public JsonError() {
    }
    /**
     * Constructor parametrizado
     * @param code
     * @param error
     * @param message 
     */
    public JsonError(String code, String error, String message) {
        this.code = code;
        this.error = error;
        this.message = message;
    }

    /**
     * Getters and Setters de los atributos
     */
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
