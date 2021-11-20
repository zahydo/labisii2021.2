package co.unicauca.solid.openclose.domain;

/**
 *
 * Entrega a Colombia. Utiliza el patrón de diseño Strategy
 *
 * @author Libardo, Julio
 */
public class ColombiaDelivery implements IDelivery {

    @Override
    public double calculateCost(Order order) {
        double result = order.getTotal() * 0.01;
        if (order.getWeight() <= 2) {
            result += 9900;
        } else {
            result += order.getWeight() * 5000;
        }
        return result;
    }

}
