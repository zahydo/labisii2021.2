/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.microkernel.plugins.surcorea;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;

/**
 *
 * @author Jose Ricardo
 */
public class SurCoreaDeliveryPlugin implements IDeliveryPlugin{
    /**
     * Calcular el costo de envío de un producto de la tienda enviado dentro de
     * Sur Corea.
     *
     */
    @Override
    public double calculateCost(Delivery delivery) {

        Product product = delivery.getProduct();

        double cost;

        //El peso del producto determina el costo.
        if (product.getWeight() <= 1) {

            cost = 3;

        } else {

            //El peso adicional después de 2 kg se cobra a 0.5 por kilo.
            cost = 3 + (product.getWeight() - 1) * 0.3;

        }

        return cost;
    }
}
