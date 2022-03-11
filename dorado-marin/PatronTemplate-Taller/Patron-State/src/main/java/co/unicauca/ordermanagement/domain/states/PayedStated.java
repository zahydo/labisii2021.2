
package co.unicauca.ordermanagement.domain.states;

import co.unicauca.ordermanagement.domain.Order;

/**
 * Estado Pagado
 * 
 * @author Fabián David Marín - Hector Fernando Dorado
 */
public class PayedStated extends OrderState{

    /**
     * constructor
     * 
     * @param order 
     */
    public PayedStated(Order order) {
        super(order);
    }
    
    /**
     * Descripción del estado
     * 
     * @return estado
     */
    @Override
    public String getStateDescription() {
        return "Pagada";
    }
    
    /**
     * Metodo que enlaza la secuencia segun las reglas de negocio
     * 
     * @param parcelNumber
     * @return 
     */
    @Override
    public OrderState orderSendOut(String parcelNumber) {
        return new SendState(getOrder());
    }
}



