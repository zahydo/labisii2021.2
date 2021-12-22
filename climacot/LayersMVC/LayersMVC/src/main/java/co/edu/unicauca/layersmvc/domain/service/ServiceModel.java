package co.edu.unicauca.layersmvc.domain.service;

import co.edu.unicauca.layersmvc.access.Factory;
import co.edu.unicauca.layersmvc.access.IProductRepository;
import co.edu.unicauca.layersmvc.domain.Product;
import co.edu.unicauca.layersmvc.domain.Response;
import co.edu.unicauca.layersmvc.infra.PublicadorRabbit;
import co.edu.unicauca.layersmvc.infra.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa el Modelo del MVC
 *
 * @author Libardo, Julio
 */
public class ServiceModel extends Subject {

    // Ahora hay una dependencia de una abstracción, no es algo concreto,
    // no sabe cómo está implementado.
    private IProductRepository repository;
    private PublicadorRabbit publicador;
    // private Gson json;

    /**
     * Inyección de dependencias en el constructor.Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     */
    public ServiceModel() {
        repository = Factory.getInstance().getRepository();
        publicador = new PublicadorRabbit();
        // json = new Gson();
    }

    public double calculateProductTax(Product product) {

        // Validate product.
        if (product == null) {
            return 0;
        }
        double TAX = 0.19d;
        double productTax = product.getPrice() * TAX;
        return productTax;
    }

    public boolean saveProduct(Product newProduct) {

        // Validate product
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
        Response response = new Response("post", newProduct);

        // Notifica a todos los observadores que el modelo cambió
        try {
            this.notifyAllObserves();
            publicador.publicar(response);
        } catch (Exception e) {}

        return true;
    }

    public List<Product> listProducts() {
        List<Product> products = new ArrayList<>();
        products = repository.list();
        return products;
    }

    public boolean updateProduct(Product newProduct) {
        // Validate product
        if (newProduct == null || newProduct.getProductId() < 0 || newProduct.getName().isEmpty()) {
            return false;
        }

        // Notifica a todos los observadores que el modelo cambió
        repository.update(newProduct);
        Response response = new Response("update", newProduct);

        try {
            this.notifyAllObserves();
            publicador.publicar(response);
        } catch (Exception e) {}

        return true;
    }
}
