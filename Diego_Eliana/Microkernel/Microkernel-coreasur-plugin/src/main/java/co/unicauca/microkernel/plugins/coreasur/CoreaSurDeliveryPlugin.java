package co.unicauca.microkernel.plugins.coreasur;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 * Plugin para envios a CoreaSur
 * @author Diego, Eliana
 */
public class CoreaSurDeliveryPlugin implements IDeliveryPlugin {

    /**
     * Calcular el costo de envío de un producto de la tienda enviado dentro de
     * CoreaSur.
     *
     */
    public double calculateCost(Delivery delivery) {
        return delivery.getDistance() * 0.003;
    }
}
