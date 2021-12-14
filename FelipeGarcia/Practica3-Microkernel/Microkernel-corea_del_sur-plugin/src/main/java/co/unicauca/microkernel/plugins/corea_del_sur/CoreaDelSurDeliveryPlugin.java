package co.unicauca.microkernel.plugins.corea_del_sur;
import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;

/**
 *
 * @author user
 */
public class CoreaDelSurDeliveryPlugin implements IDeliveryPlugin {

    public double calculateCost(Delivery delivery){
        Product product = delivery.getProduct();
        double widht = product.getWidth();
        double height= product.getHeight();
        
        double cost;
        
        if(height <= 4){
            cost = (widht <= 4) ? 7 : 8;
        } else {
            cost = (widht <= 4) ? 9 : 10;
        }
        
        return cost;
    }
}
