package co.edu.unicauca.Productor.access;

import co.edu.unicauca.Productor.domain.Product;
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
