package co.unicauca.microkernel.plugins.peru;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 * Plugin para envios a Peru
 * @author Juan Fernando Abella
 */
public class PeruDeliveryPlugin implements IDeliveryPlugin {

    /**
     * Calcular el costo de envío de un producto de la tienda enviado a
     * peru.
     * 
     * Codigo : pe
     *
     */
    public double calculateCost(Delivery delivery) {

        Product product = delivery.getProduct();
        double distance = delivery.getDistance();
        double cost;
        
        if(product.getDepth()<=27){
            cost = (distance <= 50 ) ? 40000 : (product.getWeight()<=2) ? 40000 + (200*(distance-50)):40000+(800*(distance-50));
        }else if(product.getDepth()<=30){
            cost = (distance <= 50 ) ? 50000 : (product.getWeight()<=2) ? 50000 + (400*(distance-50)):50000+(1600*(distance-50));
        }else{
            cost = (distance <= 50 ) ? 60000 : (product.getWeight()<=2) ? 60000 + (600*(distance-50)):60000 + (2400*(distance-50));
        }
        
        return cost * 0.0010; // se hace la conversion de pesos colombianos a soles peruanos.
    }
    
}
