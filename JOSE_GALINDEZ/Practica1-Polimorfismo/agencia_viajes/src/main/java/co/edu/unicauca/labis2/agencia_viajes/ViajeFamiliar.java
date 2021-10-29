/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.labis2.agencia_viajes;

import java.util.Date;

/**
 *
 * @author Yaquelin - joser
 */
public class ViajeFamiliar extends Viaje {

    /**
     * Cantidad de integrantes de la familia
     */
    private int familia;
    //Constructor getters and setters

    public ViajeFamiliar() {
        super();
        this.familia = 0;
    }
    
    public ViajeFamiliar(String origen, String destino, int costo, Date fechaSalida, Date fechaLlegada, int familia) {
        super(origen, destino, costo, fechaSalida, fechaLlegada);
        this.familia = familia;
    }

    public int getFamilia() {
        return familia;
    }

    public void setFamilia(int familia) {
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
