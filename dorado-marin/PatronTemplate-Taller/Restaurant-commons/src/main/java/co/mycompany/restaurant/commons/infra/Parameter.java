package co.mycompany.restaurant.commons.infra;

/**
 * @author Fabián David Marín - Hector Fernando Dorado
 */
public class Parameter {
    
    /**
     * atributos
     */
    
    private String name;
    private String value;
    
    /**
     * constructor de parametro
     * @param name nombre del parametro
     * @param value valor
     */
    public Parameter(String name, String value) {
        this.name = name;
        this.value = value;
    }
    /**
     * Constructor vacio
     */
    public Parameter() {

    }

    /**
     *  Getters and Setters 
     */
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
