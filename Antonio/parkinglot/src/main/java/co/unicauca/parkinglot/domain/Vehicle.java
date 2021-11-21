/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.domain;

/**
 *
 * @author Antonio E
 */
public class Vehicle {
    
    private int vehicleId;
    private String plate;
    private TypeEnum type;

    public Vehicle(int vehicleId, String plate, TypeEnum type) {
        this.vehicleId = vehicleId;
        this.plate = plate;
        this.type = type;
    }
    
    public Vehicle() {
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
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
        return "Vehículo de placas: " + plate + "\nTipo: " + type;
    }
}
