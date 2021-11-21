/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

/**
 *
 * @author Jose_R
 */
public class Vehicle {

    /**
     * Placa
     */
    private String plate;
    /**
     * Tipo: Moto, carro, camion
     */
    private TypeEnum type;
    /**
     * constructor por parametros del vehiculo 
     * @param plate Placa
     * @param type  Tipo: Moto, carro, camion
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
     * Metodo para retornar la placa
     * @return retorna la placa del vehiculo
     */
    public String getPlate() {
        return plate;
    }
    /**
     * Metodo para final la placa
     * @param plate placa del vehiculo
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }
    /**
     * Metodo para retornar el tipo de vehiculo
     * @return el tipò de vehiculo
     */
    public TypeEnum getType() {
        return type;
    }
    /**
     * Metodo para fijar el tipo de vehiculo
     * @param type tipo de vehiculo
     */
    public void setType(TypeEnum type) {
        this.type = type;
    }

    /**
     * Metodo para mostrar los datos del vehiculo
     * @return una cadena de texto con los datos del vehiculo
     */
    @Override
    public String toString() {
        return "Vehicle{" + "plate=" + plate + ", type=" + type + '}';
    }

}
