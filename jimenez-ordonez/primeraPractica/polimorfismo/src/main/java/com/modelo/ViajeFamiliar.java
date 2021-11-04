package com.modelo;

import java.util.Date;

public class ViajeFamiliar extends Viaje {
    /**
     * Cantidad de integrantes de la familia.
     */
    private int familia;

    /**
     * Constructor parametrizado.
     * 
     * @param origen
     * @param destino
     * @param costo
     * @param fechaSalida
     * @param fechaLlegada
     * @param familia
     */
    public ViajeFamiliar(String origen, String destino, int costo, Date fechaSalida, Date fechaLlegada, int familia) {
        super(origen, destino, costo, fechaSalida, fechaLlegada);
        this.familia = familia;
    }

    /**
     * getter familia.
     * 
     * @return
     */
    public int getFamilia() {
        return familia;
    }

    /**
     * setter familia.
     * 
     * @param familia
     */
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