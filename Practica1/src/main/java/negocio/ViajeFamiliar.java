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
public class ViajeFamiliar extends Viaje{
    //Atributos clase hija ViajeFamiliar
    private int familia;  
    
    
   //Getters / Setters 
    public int getFamilia() {
        return familia;
    }

    public void setFamilia(int familia) {
        this.familia = familia;
    }
    
    //Métodos 
    public ViajeFamiliar(String origen, String destino, int costo, Date salida, Date llegada, int familia){
        super(origen, destino, costo, salida, llegada); 
        this.familia = familia;  
    }
    
    @Override 
    public String descripcion(){
        return "Viaje para disfrutar con toda tu familia"; 
    }
    
    public String cualquierMetodo2(){
        return "Método implementado en la clase hija viaje familiar"; 
    }
    
}
