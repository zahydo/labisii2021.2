/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.subscriber.domain.acces;

import com.mycompany.subscriber.domain.Product;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class GestorProductos {
    private final ArrayList<Product> almacenamiento; 
    
    public GestorProductos(){
        almacenamiento = new ArrayList<>();  
    }

    public Integer existeProducto(Product p){
        for(Product each: almacenamiento){
            if(each.getProductId() == p.getProductId()){
                return almacenamiento.indexOf(each); 
            }
        }
        return -1; 
    }
    
    public boolean AgregarProducto(Product p){
        if(existeProducto(p) == -1){
            almacenamiento.add(p); 
            return true; 
        }
       return false; 
    }
    
    public boolean ModificarProducto(Product p){
        int aux = existeProducto(p); 
        if( aux != -1){
            almacenamiento.set(aux, p); 
            return true; 
        }
        return false; 
    }
    
    public boolean IsEmpty(){
         return almacenamiento.isEmpty(); 
    }

    public ArrayList<Product> getAlmacenamiento() {
        return almacenamiento;
    }

    
}
