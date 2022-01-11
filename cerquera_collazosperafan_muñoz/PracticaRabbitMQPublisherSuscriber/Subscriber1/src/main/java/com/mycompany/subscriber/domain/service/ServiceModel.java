/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.subscriber.domain.service;

import com.mycompany.subscriber.domain.acces.Factory;
import com.google.gson.Gson;
import com.mycompany.subscriber.domain.Product;
import com.mycompany.subscriber.domain.acces.GestorProductos;

import com.mycompany.subscriber.infra.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cerqu
 */
public class ServiceModel extends Subject {

    private static GestorProductos gestorProd;

    public ServiceModel() {
        gestorProd = Factory.getInstance().getGestorProductos();
    }

    public boolean saveProduct(Product newProduct) throws InterruptedException {
        if (newProduct == null || newProduct.getProductId() < 0 || newProduct.getName().isEmpty()) {
            return false;
        }

        int productoExiste = gestorProd.existeProducto(newProduct);
        if (productoExiste != -1) {
            return false;
        }
        gestorProd.AgregarProducto(newProduct);
        this.notifyAllObserves();

        return true;
    }

    public List<Product> listProducts() {
        List<Product> products = new ArrayList<>();
        products = gestorProd.getAlmacenamiento();
        return products;
    }

    public boolean actualizarProducto(Product newProduct) throws InterruptedException {
        if (newProduct == null || newProduct.getProductId() < 0 || newProduct.getName().isEmpty()) {
            return false;
        }
        gestorProd.ModificarProducto(newProduct);
        this.notifyAllObserves();
        return true;
    }

    public void gestionarGson(String msg) throws InterruptedException {
        Gson gson = new Gson();
        Product producto;
        String aux = "";
        if (msg.indexOf("add", 1) == 1) {
            aux = msg.substring(5);
            producto = gson.fromJson(aux, Product.class);
            saveProduct(producto);
        } else if (msg.indexOf("update", 1) == 1) {
            aux = msg.substring(8);
            producto = gson.fromJson(aux, Product.class);
            actualizarProducto(producto);
        }
    }

}
