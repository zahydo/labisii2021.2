package co.unicauca.microkernel.plugins.southkorea;
import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;

public class SouthKoreaDeliveryPlugin implements IDeliveryPlugin {
    /**
     * Se calcula el costo de envio usando peso y distancia
     * @param delivery 
     * @return costo
     */
    public double calculateCost(Delivery delivery) {

        Product product = delivery.getProduct();
        double weight = product.getWeight();
        double distance = delivery.getDistance();

        double cost = 0.0;

        if (weight <= 2) {
            cost = distance<30?2.0:3.5;
        } else {
            cost = distance/weight;
        }

        return cost;

    }
}
