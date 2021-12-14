

package co.unicauca.microkernel.plugins.corea;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;

/**
 *
 * @author juan sebastian
 */
public class CoreaDeliveryPlugin {
 /**
     * El cálculo de corea del sur es una mezcla de peso y distancia.
     *
     * @param delivery envío
     * @return costo del envío
     */
    public double calculateCost(Delivery delivery) {

        Product product = delivery.getProduct();
        double weight = product.getWeight();
        double distance = delivery.getDistance();

        double cost;

        if (weight <= 2) {

            cost = (distance <= 20) ? 6 : 4;

        } else {

            cost = (distance <= 20) ? 7 : 5;

        }

        return cost;

    }
}
