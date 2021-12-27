/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.layersmvc.domain.service;

import co.edu.unicauca.layersmvc.domain.Product;
import java.util.ArrayList;

/**
 *
 * @author XssIsor
 */
public class ServiceMemory {
    
    private final ArrayList<Product> productRepo;
    
    public ServiceMemory(){
        productRepo = new ArrayList<>();
    }
    
    private int productExists(Product product){
        for(Product inventory: productRepo){
            if(product.getProductId() == inventory.getProductId())
                return productRepo.indexOf(inventory);
        }
        return -1;
    }
    
    public boolean add(Product product){
        if(this.productExists(product) == -1){
            return false;
        }else{
            this.productRepo.add(product);
        }
        return true;
    }
    
    public boolean update(Product product){
        int index = this.productExists(product);
        if(index != -1){
            this.productRepo.set(index, product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProductRepo() {
        return productRepo;
    }
    
    
}
