/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.domain.Food;
import java.util.List;

/**
 *
 * @author David E
 */
public interface IFoodRepository {


    /**
     * Crea un Plato
     *
     * @param food plato
     * @return el id de la comida
     */
    public String create(Food food);
    
    /**
     * Buscar un plato utilizando su id.
     *
     * @param id id del plato
     * @return objeto Food
     */
    public Food findById(int id);

}
