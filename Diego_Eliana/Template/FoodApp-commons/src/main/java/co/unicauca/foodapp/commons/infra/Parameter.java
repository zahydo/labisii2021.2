package co.unicauca.foodapp.commons.infra;

/**
 * Parametro.
 * Lo usa la clase Protocol
 * @author Diego Collazos, Eliana Cerquera
 */
public class Parameter {

    /**
     * Atributo nombre del parametro
     */
    private String name;

    /**
     * Atributo valor del parametro
     */
    private String value;

    /**
     * Constructor parametrizado
     * @param name nuevo
     * @param value nuevo
     */
    public Parameter(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Constructor por defecto
     */
    public Parameter() {}

    /**
     * Getter del nombre
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter del nombre
     * @param name nuevo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter del valor
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * Setter del valor
     * @param value nuevo
     */
    public void setValue(String value) {
        this.value = value;
    }
}
