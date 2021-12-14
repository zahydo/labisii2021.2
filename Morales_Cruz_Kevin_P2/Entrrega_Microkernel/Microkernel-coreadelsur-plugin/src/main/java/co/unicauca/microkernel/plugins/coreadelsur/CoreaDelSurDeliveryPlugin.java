package co.unicauca.microkernel.plugins.coreadelsur;
import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;

public class CoreaDelSurDeliveryPlugin implements IDeliveryPlugin {
    /**
     * El cálculo de Corea Del Sur  peso 
     * ademas de un costo adicional del 6%.
     *
     * @param delivery envío
     * @return costo del envío
     */
    public double calculateCost(Delivery delivery) {

        Product product = delivery.getProduct();
        double weight = product.getWeight();

        double cost;

        if (weight <= 2) {

            cost = weight;
            cost=cost*0.06+cost;
        } else {

            cost = weight +5.5;
            cost=cost*0.06+cost;
        }

        return cost;

    }
}
