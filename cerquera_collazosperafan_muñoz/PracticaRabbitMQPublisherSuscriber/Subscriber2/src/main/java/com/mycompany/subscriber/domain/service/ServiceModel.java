package com.mycompany.subscriber.domain.service;

import com.google.gson.Gson;
import com.mycompany.subscriber.access.Factory;
import com.mycompany.subscriber.access.IProductRepository;
import com.mycompany.subscriber.domain.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa el Modelo del MVC
 *
 * @author Libardo, Julio
 */
public class ServiceModel{


    private IProductRepository repository;
  
    public ServiceModel() {
        repository = Factory.getInstance().getRepository();
    }
    
    
    public double calculateProductTax(Product product) {

        //Validate product.
        if (product == null) {
            return 0;
        }
        double TAX = 0.19d;
        double productTax = product.getPrice() * TAX;
        return productTax;
    }

    public boolean saveProduct(Product newProduct) throws InterruptedException {

        //Validate product
        if (newProduct == null || newProduct.getProductId() < 0 || newProduct.getName().isEmpty()) {
            return false;
        }

        // Antes de guardar, falta validar que no exista el producto
        Product productAux = repository.find(newProduct.getProductId());

        if (productAux != null) {
            // El producto ya existe
            return false;
        }

        repository.save(newProduct);
        // Notifica a todos los observadores que el modelo cambió
        return true;
    }

    public List<Product> listProducts() {
        List<Product> products = new ArrayList<>();
        products = repository.list();
        return products;
    }

    public boolean updateProduct(Product newProduct) throws InterruptedException {
        //Validate product
        if (newProduct == null || newProduct.getProductId() < 0 || newProduct.getName().isEmpty()) {
            return false;
        }

        // Notifica a todos los observadores que el modelo cambió
        repository.update(newProduct);
        System.out.print(this +  ": Actualizó base datos");
        System.out.flush();
        return true;
    }

    public void gestionarMsg(String msg) throws InterruptedException {
        Gson gson = new Gson();  
        Product prod ; 
        String aux = ""; 
        if (msg.indexOf("add", 1) == 1) {
            aux = msg.substring(5); 
            prod = gson.fromJson(aux, Product.class); 
            saveProduct(prod);
        } else if (msg.indexOf("update", 1) == 1) {
            aux = msg.substring(8); 
            prod = gson.fromJson(aux, Product.class); 
            updateProduct(prod);
        }
    }
}
