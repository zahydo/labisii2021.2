/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

/**
 *
 * @author 57322
 */
public class Vehicle {

    //Atributos
    private String plate;
    private TypeEnum type;

    /**
     *
     * @param plate
     * @param type
     */
    public Vehicle(String plate, TypeEnum type) {
        this.plate = plate;
        this.type = type;
    }

    public Vehicle() {

    }

    //Getters and Setters
    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public String toString() {

        return "Placa:" + this.getPlate() + " " + "Tipo Vehiculo:" + this.getType();
    }

}
