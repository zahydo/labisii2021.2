package co.unicauca.solid.dip.domain.service;

import co.unicauca.solid.dip.domain.access.ProductRepository;
import co.unicauca.solid.dip.domain.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Libardo, Julio
 */
public class Service {

    // Aqui hay una dependencia directa con un módulo inferior
    // Se debería reemplazar la dependencia con una abstracción
    private ProductRepository repository;

    public Service() {
        repository = new ProductRepository();
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

    public boolean saveProduct(Product newProduct) {

        //Validate product
        if (newProduct == null || newProduct.getProductId() < 0 || newProduct.getName().isBlank()) {
            return false;
        }

        repository.saveProduct(newProduct);
        return true;

    }

    public List<Product> listProducts() {
        List<Product> products = new ArrayList<>();
        products = repository.listProducts();;

        return products;
    }

}
