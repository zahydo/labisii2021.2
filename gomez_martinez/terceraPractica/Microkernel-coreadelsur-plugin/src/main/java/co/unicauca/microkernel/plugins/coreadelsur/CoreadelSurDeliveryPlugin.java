package co.unicauca.microkernel.plugins.coreadelsur;
import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;



public class CoreadelSurDeliveryPlugin implements IDeliveryPlugin {

    /**
     * The calculation of a delivery to South Korea depends on the weight.
     *
     * @param delivery envío
     * @return costo del envío
     */
    
    @Override
    public double calculateCost(Delivery delivery) {
        
        Product product = delivery.getProduct();
        double weight = product.getWeight();
        double cost;

        //If the package weighs less than one kilogram it has a standard cost = 10 
        if (weight <= 1) {

            cost = 10;

        } else {
            
            //Weight over 1 kg is charged at 1.5 per kg.
            cost = 10 + (weight - 1)*1.5;
        }
        
        return cost;
        
    }
}
