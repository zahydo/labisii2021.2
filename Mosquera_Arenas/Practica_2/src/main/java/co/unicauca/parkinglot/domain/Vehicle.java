/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.domain;

/**
 * Clase Vehiculo
 * @fecha 2021/11/17
 * @author Miguel Mosquera, Sebastian Arenas
 */
public class Vehicle {
    private String plate;   //Placa del vehiculo
    private TypeEnum type;      //Tipo de Vehiculo

    /** 
     * Constructor por parametro del vehiculo
     * @param placa, tipo de vehiculo
     */
    public Vehicle(String plate, TypeEnum type) {
        this.plate = plate;
        this.type = type;
    }
    
    /** 
     * Constructor por defecto
     */
    public Vehicle() {    }

    /** 
     * Retorna la placa
     * @return la placa
     */
    public String getPlate() {
        return plate;
    }

    /** 
     * Da un valor a la placa
     * @return la placa
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    /** 
     * Da un valor a el tipo de vehiculo
     */
    public TypeEnum getType() {
        return type;
    }

    /** 
     * Retorna el tipo
     * @return type
     */
    public void setType(TypeEnum type) {
        this.type = type;
    }

    /** 
     * Retorna como string los atributos del objeto
     * @return en texto todos los datos de este objeto
     */
    @Override
    public String toString() {
        return "Vehicle{" + "plate=" + plate + ", type=" + type + '}';
    }
    
    
    
}
