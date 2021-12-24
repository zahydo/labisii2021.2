package co.edu.unicauca.Subscriptor1.access;

import co.edu.unicauca.Subscriptor1.domain.Product;
import java.util.List;

/**
 *
 * @author Libardo, Julio
 */
public interface IProductRepository {

    boolean save(Product newProduct);

    boolean update(Product newProduct);
    
    Product find(int id);

    List<Product> list();
}
