package co.unicauca.solid.openclose.domain;

/**
 * Interface de Entrega Utiliza el patrón de diseño Strategy
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public interface IDelivery {

    double calculateCost(Order order);
}
