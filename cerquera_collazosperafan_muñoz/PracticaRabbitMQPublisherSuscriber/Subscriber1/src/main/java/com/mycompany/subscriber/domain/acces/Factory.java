/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.subscriber.domain.acces;

import com.mycompany.subscriber.domain.acces.GestorProductos;

/**
 *
 * @author ASUS
 */
public class Factory {
    private static Factory instance;  
    private static GestorProductos gestor;  
    private Factory(){
        
    }
    
    public static Factory getInstance(){
        if (instance == null) {
            instance = new Factory(); 
            gestor = new GestorProductos(); 
        }
        return instance;
    }
    
    public GestorProductos getGestorProductos(){
        return gestor;  
    } 
}
