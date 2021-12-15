package co.unicauca.microkernel.plugins.southkorea;
import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 *
 * @author artur
 */
public class SouthKoreaDeliveryPlugin implements IDeliveryPlugin{
    
    public double calculateCost(Delivery delivery) {

        Product product = delivery.getProduct();
        double weight = product.getWeight();
        double distance = delivery.getDistance();

        double cost;

        if (product.getWeight() <= 2) {

            cost = 25;

        } else {

            cost = 25 + delivery.getDistance()*2 + (product.getWeight() - 2) * 3;

        }

        return cost;

    }
}
