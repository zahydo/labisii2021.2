/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.access;

import co.unicauca.travelagency.commons.domain.Food;

/**
 *
 * @author Julian Martinez, Paula Peña
 */
public interface IRepository {

    /**
     * Busca un plato por su id
     *
     * @param id identificación del plato
     * @return objeto de tipo Food
     */
    public Food obtenerPlato(String id);

    /**
     *
     * @param food el plato a guardar
     * @return String reponse
     */
    public String crearPlato(Food food);

}
