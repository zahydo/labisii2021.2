package co.unicauca.microkernel.plugins.CoreaDelSur;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 * Plugin para envios a Corea Del Sur
 * @author Juan Fernando Abella
 */
public class CoreaDelSurDeliveryPlugin implements IDeliveryPlugin {

    /**
     * Calcular el costo de envío de un producto de la tienda enviado a
     * Corea del Sur.
     * 
     * Codigo : cs
     *
     */
    public double calculateCost(Delivery delivery) {

        Product product = delivery.getProduct();
        double distance = delivery.getDistance();
        double cost;
        
        if(product.getDepth()<=27){
            cost = (distance <= 50 ) ? 80000 : (product.getWeight()<=2) ? 80000 + (400*(distance-50)):80000+(1600*(distance-50));
        }else if(product.getDepth()<=30){
            cost = (distance <= 50 ) ? 100000 : (product.getWeight()<=2) ? 100000 + (800*(distance-50)):100000+(3200*(distance-50));
        }else{
            cost = (distance <= 50 ) ? 120000 : (product.getWeight()<=2) ? 120000 + (1200*(distance-50)):120000 + (4800*(distance-50));
        }
        return cost * 0.31; // Se hace la conversion de pesos colombianos a won surcoreano
    }
    
}

