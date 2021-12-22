/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.layersmvc.commons;

/**
 *
 * @author David E
 */
public class Product_protocol {
    
    private Product producto;
    private String accion;
    
    public Product_protocol(Product producto,String accion){
        this.producto = producto;
        this.accion = accion;
    }

    public Product getProducto() {
        return producto;
    }

    public String getAccion() {
        return accion;
    }
    
}
