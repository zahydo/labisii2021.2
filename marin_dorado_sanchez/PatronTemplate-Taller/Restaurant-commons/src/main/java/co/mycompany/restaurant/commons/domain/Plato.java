package co.mycompany.restaurant.commons.domain;

import java.util.Date;

/**
 * @author Fabián David Marín - Hector Fernando Dorado - Juan Sebastian Sanchez
 * 
 *  Clase plato 
 */
public class Plato {

    /**
     * Id del plato
     */
    private String PlatoId;
    /**
     * Nombre del plato
     */
    private String PlatoNombre;
    /**
     * Pecio del plato
     */
    private String PlatoPrecio;
    /**
     * Dscripcion del plato
     */
    private String PlatoDescripcion;

    /**
     * Constructor del plato
     * 
     * @param platoNombre
     * @param platoPrecio
     * @param platoDescripcion 
     */
    public Plato(String platoId ,String platoNombre, String platoPrecio, String platoDescripcion) {
        this.PlatoId = platoId;
        this.PlatoNombre = platoNombre;
        this.PlatoPrecio = platoPrecio;
        this.PlatoDescripcion = platoDescripcion;
    }
    
    
    /**
     * Constructor vacio
     */
    public Plato(){
        
    }
    
        /**
     * @return the PlatoId
     */
    public String getPlatoId() {
        return PlatoId;
    }

    /**
     * @param PlatoId the PlatoId to set
     */
    public void setPlatoId(String PlatoId) {
        this.PlatoId = PlatoId;
    }
    
    /**
     * @return the PlatoNombre
     */
    public String getPlatoNombre() {
        return PlatoNombre;
    }

    /**
     * @param PlatoNombre the PlatoNombre to set
     */
    public void setPlatoNombre(String PlatoNombre) {
        this.PlatoNombre = PlatoNombre;
    }

    /**
     * @return the PlatoPrecio
     */
    public String getPlatoPrecio() {
        return PlatoPrecio;
    }

    /**
     * @param PlatoPrecio the PlatoPrecio to set
     */
    public void setPlatoPrecio(String PlatoPrecio) {
        this.PlatoPrecio = PlatoPrecio;
    }

    /**
     * @return the PlatoDescripcion
     */
    public String getPlatoDescripcion() {
        return PlatoDescripcion;
    }

    /**
     * @param PlatoDescripcion the PlatoDescripcion to set
     */
    public void setPlatoDescripcion(String PlatoDescripcion) {
        this.PlatoDescripcion = PlatoDescripcion;
    }
}
