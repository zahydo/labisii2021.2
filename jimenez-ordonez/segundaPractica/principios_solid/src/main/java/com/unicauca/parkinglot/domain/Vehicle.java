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

    @Override
    public String toString() {
        return "Vehicle [plate=" + plate + ", type=" + type + "]";
    }    

}
