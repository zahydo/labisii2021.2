
package co.unicauca.unicauca.solid.srp.main;

import co.unicauca.unicauca.solid.srp.domain.Product;
import co.unicauca.unicauca.solid.srp.service.Service;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class ClientMain {


    public static void main(String[] args) {
        Service service = new Service();
        
        // Crear dos productos y grabarlos
        Product newProduct = new Product(1,"TV samgung RTR-123", 2500000d);         
        service.saveProduct(newProduct);

        newProduct = new Product(2,"Nevera LG FGET-233", 2500000d);
        service.saveProduct(newProduct);
        
        // Listar los productos
        for(Product p: service.listProducts()){
            System.out.println(p);
        }
        
        
        
    }
    
}
