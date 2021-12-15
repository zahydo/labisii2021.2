package co.unicauca.microkernel.plugins.southKorea;
import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;

public class SouthKoreaDeliveryPlugin implements IDeliveryPlugin {
    /**
     * El cálculo de corea del sur es un impuesto si el peso >= 2 y siempre es peso * distancia..
     *
     * @param delivery envío
     * @return costo del envío
     */
    public double calculateCost(Delivery delivery) {

        Product product = delivery.getProduct();
        double weight = product.getWeight();
        double distance = delivery.getDistance();

        double cost;

        if (weight >= 2) {

            cost = distance * weight * 1.20;

        } else {

        	cost = distance * weight;

        }

        return cost;

    }
}
