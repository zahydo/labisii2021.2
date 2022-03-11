/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.client.access;

import co.unicauca.travelagency.commons.infra.Utilities;

/**
 *
 * @author Julian Martinez, Paula Peña
 */
public class Factory {

    private static Factory instance;

    private Factory() {
    }

    /**
     * Singleton Pattern
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la interface IRestaurantAccess
     *
     * @return una clase hija de la abstracción IRepositorioClientes
     */
    public IRestaurantAccess getRestaurantService() {

        IRestaurantAccess result = null;
        String type = Utilities.loadProperty("customer.service");

        switch (type) {
            case "default":
                result = new RestaurantAccessImpSockets();
                break;
            default:
                result = new RestaurantAccessImpSockets();
                break;
        }
        return result;

    }

}
