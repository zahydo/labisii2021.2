package co.unicauca.microkernel.plugins.corea_del_Sur;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 * Plugin para envios a Mexico
 * @author Libardo, Julio
 */
public class CoreaDelSurDeliveryPlugin implements IDeliveryPlugin {

    /**
     * El cálculo de Corea del sur es una mezcla de peso, distancia y volumen.
     *
     * @param delivery envío
     * @return costo del envío
     */
    public double calculateCost(Delivery delivery) {
        /**
         * Se utiliza el ancho, largo, y profundidad del producto para calcular el volumen
         */
        Product product = delivery.getProduct();
        double weight = product.getWeight();
        double distance = delivery.getDistance();
        double volumen = product.getWidth() * product.getHeight() * product.getDepth();
        double impuesto = 0.8;
        double gasolina = 2.5;
        
        double cost;
        
        /**
         * si la distancia es mayor a 5 el costo se calcula con la suma de la distancia*gasolina
         * mas el peso*impuesto mas el volumen*0.25
         */
        if (distance < 5 ) {

            cost = (weight <= 4) ? (gasolina*distance)+(volumen) : (gasolina*distance)+(weight*impuesto) + volumen*0.25;

        } else {

            cost = (gasolina*distance)+(weight*impuesto) + volumen*0.25;

        }

        return cost;

    }
}
