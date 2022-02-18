/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.layersmvc.access;

import co.edu.unicauca.layersmvc.domain.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de ICustomerRepository. Utilliza arreglos en memoria
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public final class RepositoryArrays implements IProductRepository {

    /**
     * Array List de clientes
     */
    private static List<Product> products;



    public RepositoryArrays() {
        if (products == null) {
            products = new ArrayList();
        }
    }

    @Override
    public boolean save(Product newProduct) {
        products.add(newProduct);
        System.out.println("[x]" + " " + products.toString());
        return true;
    }

    @Override
    public boolean update(Product newProduct) {
        int index = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == newProduct.getProductId()) {
                products.set(i, newProduct);
                System.out.println("[x]" + " " + products.toString());
                return true;
            }
        }
        System.out.println("[x]" + " " + products.toString());
        return false;
    }

    @Override
    public Product find(int id) {
        for (Product product : products) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

