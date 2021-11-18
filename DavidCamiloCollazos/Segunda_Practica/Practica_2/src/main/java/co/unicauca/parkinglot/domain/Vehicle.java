/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.domain;

/**
 *
 * @author David E
 */
public class Vehicle {
    private String plate;
    private TypeEnum type;
    
    public Vehicle(){
        
    }
    /**
     * constructor incializa clase vehiculo
     */
    public Vehicle(String plate, TypeEnum tipo){
        this.plate = plate;
        this.type = tipo;
    }

    /**
     * @return the plate
     */
    public String getPlate() {
        return plate;
    }

    /**
     * @param plate the plate to set
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    /**
     * @return the type
     */
    public TypeEnum getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TypeEnum type) {
        this.type = type;
    }
    
}
