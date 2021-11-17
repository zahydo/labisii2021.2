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
     * @return String
     */
    public String getPlate() {
        return plate;
    }

    
    /** 
     * @param plate
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    
    /** 
     * @return TypeEnum
     */
    public TypeEnum getType() {
        return type;
    }

    
    /** 
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
