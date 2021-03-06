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
    
    private String actionType;

    public Product(int productId, String name, double price, String actionType) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.actionType = actionType;
    }
    
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public Product(String productInfo) {
        this.productId = 1;
        this.name = "Test";
        this.price = 0.0;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
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
        return "Se agregó o modificó el siguiente producto Product {" + "id= " + productId + ", name= " + name + ", price= " + price + '}';
    }

}
