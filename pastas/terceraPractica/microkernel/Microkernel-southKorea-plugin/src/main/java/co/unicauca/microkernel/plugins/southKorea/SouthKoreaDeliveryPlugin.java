package co.unicauca.microkernel.plugins.southKorea;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 * Plugin para envios a Mexico
 * @author Libardo, Julio
 */
public class SouthKoreaDeliveryPlugin implements IDeliveryPlugin {
    /**
     * El cÃ¡lculo de China es un impuesto si el peso >= 2 y siempre es peso * distancia.
     *
     * @param delivery envÃ­o
     * @return costo del envÃ­o
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
