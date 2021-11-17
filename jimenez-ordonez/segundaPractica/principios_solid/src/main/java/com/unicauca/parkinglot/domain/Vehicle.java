package com.unicauca.parkinglot.domain;

public class Vehicle {    

    private String plate;
    private TypeEnum type;
    
    public Vehicle() {
    
    }
    
    public Vehicle(String plate, TypeEnum type) {
        this.plate = plate;
        this.type = type;
    }

    
    /** 
     * Retorna placa del vehiculo
     * @return String
     */
    public String getPlate() {
        return plate;
    }

    
    /** 
     * Usado para cambiar el valor de la placa     * @param plate
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    
    /** 
     * Retorna el tipo del vehiculo
     * @return TypeEnum
     */
    public TypeEnum getType() {
        return type;
    }

    
    /** 
     * Usado para cambiar el tipo de vehiculo
     * @param type
     */
    public void setType(TypeEnum type) {
        this.type = type;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Vehicle [plate=" + plate + ", type=" + type + "]";
    }    

}
