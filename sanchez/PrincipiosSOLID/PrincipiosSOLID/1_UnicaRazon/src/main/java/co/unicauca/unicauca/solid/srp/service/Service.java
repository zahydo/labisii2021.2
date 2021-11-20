package co.unicauca.unicauca.solid.srp.service;

import co.unicauca.unicauca.solid.srp.domain.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class Service {

    private ProductRepository repository;

    public Service() {
        repository = new ProductRepository();
    }
    /**
     * Maneja una lógica de negocio simple para calcular un impuesto del producto
     * @param product producto a calcular impuesto
     * @return 
     */
    public double calculateProductTax(Product product) {

        //Validate product.
        if (product == null) {
            return 0;
        }
        double TAX = 0.19d;
        double productTax = product.getPrice() * TAX;
        return productTax;
    }
    /**
     * Graba el producto en la base de datos
     * @param newProduct producto a ser grabado
     * @return true si lo graba en la bd, false en caso contrario
     */
    public boolean saveProduct(Product newProduct) {

        //Validate product
        if (newProduct == null || newProduct.getId() < 0 || newProduct.getName().isBlank()) {
            return false;
        }

        repository.saveProduct(newProduct);
        return true;

    }
    /**
     * Listar productos
     * @return Lista de Productos
     */
    public List<Product> listProducts() {
        List<Product> products = new ArrayList<>();
        products = repository.listProducts();;
        return products;
    }


}
