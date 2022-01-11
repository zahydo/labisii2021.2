package co.edu.unicauca.layersmvc.domain;

/**
 * Producto de una tienda
 *
 * @author Libardo, Julio
 */
public class Product {

    private int productId;

    private String name;

    private double price;
    
    private String accion;
    
    

    public Product(int productId, String name, double price, String accion) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.accion = accion;
    }

    public Product(String productInfo) {
        this.productId = 1;
        this.name = "Test";
        this.price = 0.0;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + productId + ", name=" + name + ", price=" + price + '}';
    }

}
