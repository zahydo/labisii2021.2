/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

/**
 * class Vehicle
 * La clase vehiculo se refiere a los veiculos que ingresan al parqueadero, con sus respectivos
 * atributos que permite identificarlos
 * @author YAQUE
 */
public class Vehicle {
    /**
     * Placa del vehículo
     */
    private String plate;
    
    /**
     * Tipo de vehículo
     */
    private TypeEnum type;

    /**
     * Constructor por parametros
     * @param plate Placa del vehículo
     * @param type Tipo de vehículo
     */
    public Vehicle(String plate, TypeEnum type) {
        this.plate = plate;
        this.type = type;
    }

    /**
     * Constructor por defecto
     */
    public Vehicle() {
    }

    /**
     * Retorna la placa del vehículo
     * @return plate Placa del vehículo
     */
    public String getPlate() {
        return plate;
    }

    /**
     * Metodo set
     * @param plate Placa del vehículo
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    /**
     * Retorna el tipo del vehículo
     * @return Tipo de vehículo
     */
    public TypeEnum getType() {
        return type;
    }

    /**
     * Metodo set
     * @param type Tipo de vehículo
     */
    public void setType(TypeEnum type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "plate=" + plate + ", type=" + type + '}';
    }
    
}
