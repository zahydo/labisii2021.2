/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parking.negocio;

/**
 *
 * @author Yenny Eliana Cerquera Yacumal
 */
public class TypeEnum {

    public static TypeEnum CAR;
    public static TypeEnum MOTO;
    public static TypeEnum TRUCK;
    //
    //Atributos
    //
    /**
     * Tipo de vehiculo que se registra
     */
    private String tipoVehiculo;
    
    //
    //Métodos
    //
    /**
     * Constructor por defecto
     */
    public TypeEnum() {
        tipoVehiculo = "";
    }
    /**
     * Constructor parametrizado
     */
    public TypeEnum(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
    //
    //Getters and setters
    //
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }  
    
}
