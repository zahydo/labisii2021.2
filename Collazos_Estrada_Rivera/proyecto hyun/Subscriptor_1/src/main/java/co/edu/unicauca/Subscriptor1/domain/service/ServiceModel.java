package co.edu.unicauca.Subscriptor1.domain.service;

import co.edu.unicauca.Subscriptor1.infra.Subject;
import co.edu.unicauca.Subscriptor1.access.Factory;
import co.edu.unicauca.Subscriptor1.access.IProductRepository;
import co.edu.unicauca.Subscriptor1.domain.Product;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

/**
 * Representa el Modelo del MVC
 *
 * @author Libardo, Julio
 */
public class ServiceModel extends Subject {

    // Ahora hay una dependencia de una abstracción, no es algo concreto,
    // no sabe cómo está implementado.
    private IProductRepository repository;

    /**
     * Inyección de dependencias en el constructor.Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     */
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

    public boolean saveProduct(Product newProduct) {

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
        this.notifyAllObserves();
        return true;
    }

    public List<Product> listProducts() {
        List<Product> products = new ArrayList<>();
        products = repository.list();
        return products;
    }

    public boolean updateProduct(Product newProduct) {
        //Validate product
        if (newProduct == null || newProduct.getProductId() < 0 || newProduct.getName().isEmpty()) {
            return false;
        }

        // Notifica a todos los observadores que el modelo cambió
        repository.update(newProduct);
        this.notifyAllObserves();
        return true;
    }

    public boolean saveProduct(JsonObject json){

        int id = json.get("id").getAsInt();
        String name = json.get("name").getAsString();
        double price = json.get("price").getAsDouble();

        Product p = new Product(id, name, price);

        if(saveProduct(p)){
            return true;
        }

        return false;
    }

}
