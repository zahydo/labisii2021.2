/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parking.negocio;

/**
 *
 * @author Yenny Eliana Cerquera Yacumal
 */
public class Vehicle {
    
    //
    //Atributos
    //
    private String placa;
    private TypeEnum tipoV;

    /**
     * Constructor por defecto
     */
    public Vehicle() {
        placa = "";
        tipoV = new TypeEnum();
    }

    /**
     * Constructor parametrizado
     * @param placa, es el código de la placa del vehículo
     * @param tipoV tipo de vehiculo
     */
    public Vehicle(String placa, TypeEnum tipoV) {
        this.placa = placa;
        this.tipoV = tipoV;
    }

    /**
     * Getters and setters
     */
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TypeEnum getTipoV() {
        return tipoV;
    }

    public void setTipoV(TypeEnum tipoV) {
        this.tipoV = tipoV;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "placa=" + placa + ", tipoV=" + tipoV + '}';
    }
    
}
