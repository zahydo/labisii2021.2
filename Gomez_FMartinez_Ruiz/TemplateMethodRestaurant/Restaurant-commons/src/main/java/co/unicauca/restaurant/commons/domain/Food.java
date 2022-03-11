/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.commons.domain;

/**
 * Clase comida
 * @author XssIsor
 */
public class Food {
    /**
     * id
     */
    private int id;
    
    /**
     * Nombre
     */
    private String name;
    
    /**
     * Tipo
     */
    private FoodTypeEnum type;

    public Food(){

    }
    /**
     * Constructor parametrizado.
     * @param id.
     * @param name.
     * @param type.
     */
    public Food(int id, String name, FoodTypeEnum type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    /**
     * Getter del id de la comida.
     * @return id int.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter del id de la comida.
     * @param id int. Valor a ser asignado.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter del nombre de la comida.
     * @return name String.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter del nombre de la comida.
     * @param name String. Valor a ser asignado.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter del tipo de comida.
     * @return type FoodTypeEnum.
     */
    public FoodTypeEnum getType() {
        return type;
    }
    
    /**
     * Setter del tipo de comida.
     * @param type FoodTypeEnum. Valor a ser asignado.
     */
    public void setType(FoodTypeEnum type) {
        this.type = type;
    }

    /**
     * Sobreescritura del método toString() para la clase comida.
     * @return String. Con la información de la comida ordenada.
     */
    @Override
    public String toString() {
        return "Food{" + "id: " + id + ", name: " + name + ", type: " + type + '}';
    }

}
