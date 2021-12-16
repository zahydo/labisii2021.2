package co.unicauca.microkernel.plugins.coreasur;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 *
 * @author ASUS
 */
public class CoreaSurDeliveryPlugin implements IDeliveryPlugin{

    public double calculateCost(Delivery delivery) {
        Product product = delivery.getProduct();
        double weight = product.getWeight();
        double distance = delivery.getDistance();

        double cost;

        if (weight <= 3) {

            cost = (distance <= 50) ? 10 : 12;

        } else {

            cost = (distance <= 50) ? 14 : 16;

        }

        return cost;

    }
    
}
