
package co.unicauca.microkernel.plugins.southkorea;
import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 *
 * @author XssIsor
 */
public class SouthKoreaDeliveryPlugin implements IDeliveryPlugin{
    
    public double calculateCost(Delivery delivery) {

        Product product = delivery.getProduct();
        double depth = product.getDepth();
        double height = product.getHeight();
        double width = product.getWidth();
        double weight = product.getWeight();
        
        double volume = depth * height * width;
        
        double density = weight/volume;
        
        double cost = 0;
        
        cost = (density <= 50) ? 10 : 30;
        
        return cost;

    }
    
}
