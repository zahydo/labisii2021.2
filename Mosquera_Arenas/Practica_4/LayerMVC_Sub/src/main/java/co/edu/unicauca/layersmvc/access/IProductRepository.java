/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicauca.layersmvc.access;

import co.unicauca.layersmvc.commons.Product;
import java.util.List;

/**
 *
 * @author David E
 */
public interface IProductRepository {
    boolean save(Product newProduct);

    boolean update(Product newProduct);
}
