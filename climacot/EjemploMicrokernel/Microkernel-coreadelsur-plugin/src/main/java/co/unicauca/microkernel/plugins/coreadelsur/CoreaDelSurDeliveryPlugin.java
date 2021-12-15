package co.unicauca.microkernel.plugins.coreadelsur;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 * Plugin para envios a corea del sur
 */
public class CoreaDelSurDeliveryPlugin implements IDeliveryPlugin {

    /**
     * Calcular el costo de envío de un producto de la tienda enviado dentro de
     * Corea del sur.
     *
     */
    public double calculateCost(Delivery delivery) {

        Product product = delivery.getProduct();

        double cost;

        //El peso del producto determina el costo.
        if (product.getWeight() <= 4) {

            cost = 5;

        } else {

            //El peso adicional después de 4 kg se cobra a 0.7 por kilo.
            cost = 7 + (product.getWeight() - 4) * 0.7;

        }

        return cost;
    }
}
