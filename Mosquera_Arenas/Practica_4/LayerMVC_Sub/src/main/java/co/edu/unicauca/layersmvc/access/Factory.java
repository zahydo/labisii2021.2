/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.layersmvc.access;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Utilities;

/**
 *
 * @author David E
 */
public class Factory {
    
    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    /**
     * Método que crea una instancia concreta de la jerarquia IProductRepository
     *
     * @return una clase hija de la abstracción IProductRepository
     */
    public IProductRepository getRepository(String arg) {  
        IProductRepository result = null;
        
        switch(arg){
            case "1":
                result = new ProductRepository_Local();
                break;
            case "2":
                result = new ProductRepository();
                break;
            default:
                System.out.println("Opcion no valida");
                System.out.println(arg);
        }

        return result;
    }
}
