/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.client.access;
import co.unicauca.travelagency.commons.domain.Food;

/**
 *
 * @author Julian Martinez, Paula Peña
 */
public interface IRestaurantAccess {

    /**
     * Obtiene um plato
     * @param id
     * @return
     * @throws Exception 
     */
    public Food obtenerPlato(String id) throws Exception;

    /**
     * Crea un plato
     * @param food
     * @return
     * @throws Exception 
     */
    public String crearPlato(Food food) throws Exception;

}
