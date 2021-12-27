package practica.logica;



public class ProductMessage {
    private final Product product;
    private final ProductAction action;
 
    public ProductMessage(Product product, ProductAction action) {
        this.product = product;
        this.action = action;
    }

    public Product getProduct() {
        return product;
    }

    public ProductAction getAction() {
        return action;
    }
}
