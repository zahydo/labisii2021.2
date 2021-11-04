package com.modelo;

import java.util.Date;

public abstract class Viaje {
    protected String origen;
    protected String destino;
    protected int costo;
    protected Date fechaSalida;
    protected Date fechaLlegada;

    /**
     * Constructor parametrizado.
     * 
     * @param origen
     * @param destino
     * @param costo
     * @param fechaSalida
     * @param fechaLlegada
     */
    public Viaje(String origen, String destino, int costo, Date fechaSalida, Date fechaLlegada) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
    }

    /**
     * getter origen.
     * 
     * @return String origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * setter origen.
     * 
     * @param origen
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * getter destino.
     * 
     * @return String destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * setter destino.
     * 
     * @param destino
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * getter costo.
     * 
     * @return int costo
     */
    public int getCosto() {
        return costo;
    }

    /**
     * setter costo.
     * 
     * @param costo
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }

    /**
     * getter fecha salida.
     * 
     * @return Date fecha salida
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     * setter fecha salida.
     * 
     * @param fechaSalida
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * getter fecha llegada.
     * 
     * @return Date fecha llegada
     */
    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    /**
     * setter fecha llegada.
     * 
     * @param fechaLlegada
     */
    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    /**
     * Metodo descripcion del viaje.
     * 
     * @return mensaje
     */ 
    public abstract String descripcion();

    /**
     * Metodo 1 polimorfismo.
     * 
     * @return mensaje
     */
    public String cualquierMetodo() {
        return "Cualquier método implementado en la clase base";
    }

    /**
     * Metodo 2 polimorfismo.
     * 
     * @return mensaje
     */
    public String cualquierMetodo2() {
        return "Cualquier método2 implementado en la clase base";
    }
}
