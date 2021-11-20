package co.unicauca.solid.openclose.main;

import co.unicauca.solid.openclose.domain.Order;
import co.unicauca.solid.openclose.domain.CountryEnum;
import co.unicauca.solid.openclose.domain.Store;

/**
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public class ClienteMain {

    public static void main(String[] args) {

        Store store = new Store();

        Order orderOne = new Order(CountryEnum.MEXICO, 8000, 1);

        Order orderTwo = new Order(CountryEnum.COLOMBIA, 100000, 10);

        double costOne = store.calculateDeliveryCost(orderOne);

        System.out.println("Order One cost:" + costOne + " pesos mexicanos");

        double costTwo = store.calculateDeliveryCost(orderTwo);
        System.out.println("Order Two cost: " + costTwo + " pesos colombianos");
    }

}
