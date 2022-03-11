/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.commons.domain;

/**
 * Comida del restaurante con domicilios
 *
 * @author Libardo, Julio David
 */
public class Food {

    private String id;
    private String name;
    private String description;

    public Food(){
    }
    
    public Food(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return "Food{" + "id=" + id + ", name=" + name + ", descripcion=" + description + '}';
    }

}