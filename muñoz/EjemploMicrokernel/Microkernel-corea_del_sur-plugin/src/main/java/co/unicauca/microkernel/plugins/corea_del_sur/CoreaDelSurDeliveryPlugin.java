package co.unicauca.microkernel.plugins.corea_del_sur;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 * Plugin para envios a Mexico
 * @author Libardo, Julio
 */
public class CoreaDelSurDeliveryPlugin implements IDeliveryPlugin {

    /**
     * Calcular el costo de envío de un producto de la tienda enviado dentro de
     * México.
     *
     */
    public double calculateCost(Delivery delivery) {

        Product product = delivery.getProduct();

        double cost;

        //El peso del producto y la distancia determinan el costo 
        if (product.getWeight() <= 6) {

            cost = 3*6 + product.getWidth()*0.8; 

        } else {
            //El peso adicional despu�s de 6 kilos se cobra a 2.35
            //La distancia a 0.75
            cost = 3*6 + (product.getWeight()-6)*2.35 + product.getWidth()*2.35; 
        }

        return cost;
    }
}
