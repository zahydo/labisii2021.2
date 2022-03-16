package co.unicauca.restaurant.commons.infra;

/**
 * Representa un error
 *
 * @author Libardo, Julio
 */
public class JsonError {

  
    private String code;
 
    private String error;
  
    private String message;

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
