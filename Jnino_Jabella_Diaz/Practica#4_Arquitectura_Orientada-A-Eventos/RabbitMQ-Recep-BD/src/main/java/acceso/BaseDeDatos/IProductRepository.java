package acceso.BaseDeDatos;

import Dominio.Product;
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
