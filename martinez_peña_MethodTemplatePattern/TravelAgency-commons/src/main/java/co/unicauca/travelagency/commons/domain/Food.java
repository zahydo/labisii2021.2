package co.unicauca.travelagency.commons.domain;

import java.util.Date;

/**
 * Cliente de la agencia de viajes
 *
 * @author Libardo, Julio
 */
public class Food {

    /**
     * Id
     */
    private String id;
    /**
     * Nombre
     */
    private String nameFood;

    /**
     * Precio
     */
    private float precio;

    /**
     * Descuento
     */
    private float descuento = 0;

/**
 * Constructor parametrizado
 * @param id
 * @param nameFood
 * @param precio
 * @param decuento 
 */
    public Food(String id, String nameFood, float precio, float decuento) {
        this.id = id;
        this.nameFood = nameFood;
        this.precio = precio;
    }

    /**
     * Constructor por defecto
     */
    public Food() {

    }
    
    /**
     * Getters and Setters
     * @return 
     */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
    
    //toString
    @Override
    public String toString(){
     return "[" + getId() + "]" + " " + "Name Food: " + getNameFood() + " " + "Price: " + getPrecio() + " "+ "Descuento" + getDescuento();   
    }

    

}
