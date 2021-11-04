/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public abstract class Viaje {
    
    //Variables de la clase padre 
    private String origen; 
    private String destino; 
    private int costo;  
    private Date salida; 
    private Date llegada;  
    
    // GETTERS / SETTERS 
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public void setLlegada(Date llegada) {
        this.llegada = llegada;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getCosto() {
        return costo;
    }

    public Date getSalida() {
        return salida;
    }

    public Date getLlegada() {
        return llegada;
    }
    
    //Métodos
    public Viaje(String origen, String destino, int costo, Date salida, Date llegada){
       this.origen = origen;  
       this.destino = destino; 
       this.costo = costo;  
       this.salida = salida; 
       this.llegada = llegada;  
    }
    
    public abstract String descripcion(); 
    
    public String cualquierMetodo(){
        return "Cualquier método implementado en la clase base"; 
    }
    
    public String cualquierMetodo2(){
        return "Cualquier método2 implementado en la clase base"; 
    }
}
