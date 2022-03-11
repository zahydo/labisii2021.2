/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.commons.infra.Utilities;

/**
 *
 * @author Sebastian_Arenas
 */
public class Factory {
    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
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
     * Método que crea una instancia concreta de la jerarquia ICustomerService
     *
     * @return una clase hija de la abstracción IRepositorioClientes
     */
    public IFoodAccess getFoodService() {

        IFoodAccess result = null;
        String type = Utilities.loadProperty("food.service");

        switch (type) {
            case "default":
                result = new FoodAccessImplSockets();
                break;
        }

        return result;
    }
}
