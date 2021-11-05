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
public class ViajeIndividual extends Viaje{
    
    public ViajeIndividual(String origen, String destino, int costo, Date salida, Date llegada){
      super(origen, destino, costo, salida, llegada);    
    }
    
    public String descripcion(){
        return "Disfruta tu viaje individual"; 
    }
    
}
