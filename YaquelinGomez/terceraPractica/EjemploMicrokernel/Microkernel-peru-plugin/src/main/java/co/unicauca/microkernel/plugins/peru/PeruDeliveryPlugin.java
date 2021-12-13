/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.plugins.peru;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 * Plugin para envios a Peru
 * @author Gomez
 */
public class PeruDeliveryPlugin implements IDeliveryPlugin {

    /**
     * Calcular el costo de envío de un producto de la tienda enviado dentro de
     * Peru.
     *
     */
    public double calculateCost(Delivery delivery) {
        
        Product product = delivery.getProduct();
        double cost;

        //El peso del producto determina el costo.
        if (product.getWeight() <= 5) {

            cost = 10;

        } else if (product.getWeight() > 5 && product.getWeight() <= 10) {

            cost = 15;

        }else {

            //El peso adicional después de 10 kg se cobra a 1.5 por kilo.
            cost = 15 + (product.getWeight() - 10) * 1.5;

        }

        return cost;
    }
}
