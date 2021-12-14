package co.unicauca.microkernel.plugins.china;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 * Plugin para envios a china
 * @author Juan Fernando Abella
 */
public class ChinaDeliveryPlugin implements IDeliveryPlugin {

    /**
     * Calcular el costo de envío de un producto de la tienda enviado a
     * china.
     * 
     * Codigo: ch
     *
     */
    public double calculateCost(Delivery delivery) {

        Product product = delivery.getProduct();
        double distance = delivery.getDistance();

        double cost;

       if(product.getHeight()<=4){
           cost = (product.getWidth()<=20) ? 100000 + (distance * 500)  : (product.getWidth()<=27)? 100000 + (distance * 1000) : 100000 + (distance * 1500); 
       }else if(product.getHeight()<=5){
           cost = (product.getWidth()<=10) ? 150000 + (distance * 1000)  : (product.getWidth()<=27)? 150000 + (distance * 2000) : 100000 + (distance * 3000); 
       }else{
          cost = (product.getWidth()<=20) ? 200000 + (distance * 1500)  : (product.getWidth()<=27)? 200000 + (distance * 3000) : 200000 + (distance * 6000);   
       }
        return cost * 0.0016; // se hace la conversion de pesos colombianos a yuanes chinos.
    }
}
