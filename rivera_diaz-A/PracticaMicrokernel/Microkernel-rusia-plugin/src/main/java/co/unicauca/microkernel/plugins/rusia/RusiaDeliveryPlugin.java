package co.unicauca.microkernel.plugins.rusia;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;

public class RusiaDeliveryPlugin implements IDeliveryPlugin {

    /**
     * El cálculo de Colombia es una mezcla de peso y distancia.
     *
     * @param delivery envío
     * @return costo del envío
     */
    @Override
    public double calculateCost(Delivery delivery) {

        Product product = delivery.getProduct();
        double weight = product.getWeight();
        double distance = delivery.getDistance();
        double width = product.getWidth();
        double height = product.getHeight();
        double depth = product.getDepth();

        double cost;
        //Calcular peso cubico en base a la fórmula: profundidad * alto x * ancho ÷ 6.000
        double pesoC = (width * height * depth) / 6000;
        if (weight > pesoC) {
            if (weight <= 3) {
                cost = (distance <= 21) ? (0.4 * distance) : (0.5 * distance);
            } else if (weight <= 6) {
                cost = (distance <= 21) ? (0.6 * distance) : (0.7 * distance);
            } else {
                cost = (distance <= 21) ? (0.8 * distance) : (0.9 * distance);
            }
        } else {
            if (pesoC <= 3) {
                cost = (distance <= 21) ? (0.2 * distance) : (0.3 * distance);
            } else if (weight <= 6) {
                cost = (distance <= 21) ? (0.4 * distance) : (0.5 * distance);
            } else {
                cost = (distance <= 21) ? (0.6 * distance) : (0.7 * distance);
            }
        }

        return cost;
    }
}
