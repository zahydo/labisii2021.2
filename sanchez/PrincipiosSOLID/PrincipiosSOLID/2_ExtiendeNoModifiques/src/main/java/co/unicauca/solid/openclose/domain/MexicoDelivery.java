package co.unicauca.solid.openclose.domain;

/**
 * Entrega a Mexico. Utiliza el patrón de diseño Strategy
 *
 * @author Libardo, Julio
 */
public class MexicoDelivery implements IDelivery {

    @Override
    public double calculateCost(Order order) {
        double result = 98;
        return result;
    }

}
