/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.plugins.coreadelsur;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;

/**
 *
 * @author 57322
 */
public class CoreaDelSurDeliveryPlugin implements IDeliveryPlugin {

    @Override
    public double calculateCost(Delivery delivery) {
        System.out.println("CÁLCULO PARA COREA DEL SUR:");
        /*Producto y características del envío*/
        Product product = delivery.getProduct();
        double weight = product.getWeight();
        double distance = delivery.getDistance();
        double height = product.getHeight();
        double width = product.getWidth();
        double cost = 0;

        double valor_base = 2500;
        int peso_base = 3;
        if (width <= 20 && height < 5 && distance < 150 && weight <= peso_base) {
            cost = valor_base * distance;//No se cobra valor adicional para el peso en este caso
            cost = cost + cost * 0.19;//IVA
        } else if (width <= 20 && height < 5 && distance < 150 && weight > peso_base && weight <= 20) {
            cost = valor_base * distance + 500 * (weight - peso_base);//Se cobra $500 adicional por cada kg que sobrepase el peso base aceptado
            cost = cost + cost * 0.19;//IVA

        } else {
            cost = valor_base * distance + 700 * (weight - peso_base);//Se cobra $500 adicional por cada kg que sobrepase el peso base aceptado
            cost = cost + cost * 0.19;//IVA
        }

        return cost;
    }

}
