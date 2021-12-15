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
 *
 * @author 57322
 */
public class PeruDeliveryPlugin implements IDeliveryPlugin {

    @Override
    public double calculateCost(Delivery delivery) {
        
        Product product = delivery.getProduct();
        double weight = product.getWeight();
        double distance = delivery.getDistance();
        double cost = 0;

        /*Cálcular costo de envío según rango de peso*/
        if (weight <= 1) {
            cost = distance * 4500 ;
            cost = cost*1.19; //Recarco de IVA
        }else if(weight >1 && weight <= 5){ 
            double costo_adicional = weight-1;//El primer Kg no se cobra
            cost = distance * 4500 + weight*1000;
        }else{
            double costo_adicional = weight-1;//El primer Kg no se cobra
            cost = distance * 4500 + weight*1500;  
        }

        return cost;
    }
    
}
