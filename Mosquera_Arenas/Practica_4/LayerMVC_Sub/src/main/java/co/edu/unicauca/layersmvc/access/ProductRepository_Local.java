/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.layersmvc.access;

import co.unicauca.layersmvc.commons.Product;
import java.util.ArrayList;


/**
 *
 * @author David E
 */
public class ProductRepository_Local implements IProductRepository{
    
    private static ArrayList<Product> productos = new ArrayList<Product>();
    
    public void imprimir(){
        for (Product producto : productos) {
            System.out.println(producto.toString());
        }
    }
    
    @Override
    public boolean save(Product newProduct) {
        boolean confirmacion = false;
        confirmacion = productos.add(newProduct);
        imprimir();
        return confirmacion;
    }

    @Override
    public boolean update(Product newProduct) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getProductId() == newProduct.getProductId()) {
                productos.set(i, newProduct);
                return true;
            }
        }
        return false;
    }   
    
    
    
}
