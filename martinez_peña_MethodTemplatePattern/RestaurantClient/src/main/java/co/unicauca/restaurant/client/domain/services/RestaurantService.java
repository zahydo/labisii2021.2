/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.client.domain.services;

import co.unicauca.restaurant.client.access.IRestaurantAccess;
import co.unicauca.travelagency.commons.domain.Food;

/**
 *
 * @author Julian Martinez, Paula Peña
 */
public class RestaurantService {

    private final IRestaurantAccess service;

    public RestaurantService(IRestaurantAccess service) {
        this.service = service;
    }

    /**
     * Accede al servicio concrto y envía la solicitud de obtener
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Food getFood(String id) throws Exception {
        return service.obtenerPlato(id);

    }

    /**
     * Accede al servicio concreto y envía la solicitud de guardado
     *
     * @param food
     * @return
     * @throws Exception
     */
    public String postFood(Food food) throws Exception {
        return service.crearPlato(food);
    }

}
