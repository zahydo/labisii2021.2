/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.tallerpolimorfismo.modelo;

import java.util.Date;

/**
 *
 * @author Daniel Ceron
 */
public class ViajeFamiliar extends Viaje {
    /**
     * Cantidad de integrantes de la familia
     */
    private int familia;

    
    //GETTER 
    public int getFamilia() {
        return familia;
    }

    //SETTER
    public void setFamilia(int familia) {
        this.familia = familia;
    }
    

    //Constructor
    public ViajeFamiliar(String origen, String destino, int costo, Date fechaSalida, Date fechaLlegada,int familia) {
        super(origen, destino, costo, fechaSalida, fechaLlegada); 
        this.familia = familia;
    }
    

    @Override
    public String descripcion() {
        return "Viaje para disfrutar con toda tu familia";
    }

    @Override
    public String cualquierMetodo2() {
        return "Método implementado en la clase hija viaje familiar";
    }
}
