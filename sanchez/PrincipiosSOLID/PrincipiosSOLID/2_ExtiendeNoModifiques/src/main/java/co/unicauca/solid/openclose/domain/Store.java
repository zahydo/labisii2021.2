package co.unicauca.solid.openclose.domain;

/**
 * Representa una tienda. Puede ver virtual o dentro de un negocio
 * Esta clase hace envío de unos productos
 * @author Libardo, Julio
 */
public class Store {
    /**
     * Calcular costo de entrega
     * @param order orden sobre la cual se calcula el costo de entrega
     * @return costo de entrega
     */
    public double calculateDeliveryCost(Order order) {

        if (order == null) {
            return -1;
        }
        // La fábrica devuelve una instancia de la jerarquia IDelivery  
        IDelivery delivery = Factory.getInstance().getDelivery(order.getCountry());
        double result = delivery.calculateCost(order);

        return result;

    }
}
