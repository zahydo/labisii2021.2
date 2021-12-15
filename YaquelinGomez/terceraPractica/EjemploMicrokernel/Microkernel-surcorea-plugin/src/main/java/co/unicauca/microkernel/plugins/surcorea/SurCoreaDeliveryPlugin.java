/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.plugins.surcorea;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 * Plugin para envios a Corea del Sur
 * @author Gomez
 */
public class SurCoreaDeliveryPlugin implements IDeliveryPlugin {

    /**
     * Calcular el costo de envío de un producto de la tienda enviado dentro de
     * Corea del Sur.
     *
     */
    public double calculateCost(Delivery delivery) {

        Product product = delivery.getProduct();

        double cost;

        //El peso del producto y la distancia de entrega determina el costo.
        if (product.getWeight() <= 5 && delivery.getDistance()<=10) {

            cost = 10;

        } else if (product.getWeight() > 5 && product.getWeight() <= 10 && delivery.getDistance()<=10) {

            cost = 15;

        }else {

            //El peso adicional después de 10 kg o una distancia mayor a 10 se cobra a 2.5 por kilo.
            cost = product.getWeight() * 2.5;
        }

        return cost;
    }
}
