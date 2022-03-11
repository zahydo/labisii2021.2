package co.unicauca.ordermanagement.domain.states;

import co.unicauca.ordermanagement.domain.Order;

/**
 * Estado ordenado
 *
 * @author ahurtado
 */
public class OrderedState extends OrderState {

    /**
     * @param order to be processed
     */
    public OrderedState(Order order) {
        super(order);
    }

    /**
     * @return description
     */
    @Override
    public String getStateDescription() {
        return "Ordenada";
    }

    @Override
    public OrderState cancel() {
        return new CanceledState(getOrder());
    }

    @Override
    public OrderState orderedPayed(){
        return new PayedStated(getOrder());
    }
    

}
