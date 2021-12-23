/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.suscriptor.domain.service;

import co.edu.unicauca.suscriptor.access.Factory;
import co.edu.unicauca.suscriptor.access.IProductRepository;
import co.edu.unicauca.suscriptor.access.ProductRepository;
import co.edu.unicauca.suscriptor.domain.Product;
import com.google.gson.Gson;

/**
 *
 * @author user
 */
public class ServiceModel {
    IProductRepository repository;
    public ServiceModel() {
        repository = Factory.getInstance().getRepository();
    }
    
    IProductRepository productRepo = new ProductRepository();
    Gson gson = new Gson();
    public boolean save(String producto){
        Product product = gson.fromJson(producto, Product.class);
        if (product != null) {
            // El producto ya existe
            return false;
        }
        productRepo.save(product);
        return true;
    }
    
    public boolean update(String producto){
        Product product = gson.fromJson(producto, Product.class);
        if (product != null) {
            // El producto ya existe
            return false;
        }
        productRepo.update(product);
        return true;
    }
}
