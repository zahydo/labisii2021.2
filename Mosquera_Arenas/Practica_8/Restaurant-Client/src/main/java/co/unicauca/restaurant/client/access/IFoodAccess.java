/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.commons.domain.Food;

/**
 *
 * @author Sebastian_Arenas
 */
public interface IFoodAccess {
    /**
     * Buscar un cliente utilizando un socket
     *
     * @param id cedula del cliente
     * @return objeto cliente
     * @throws Exception error al buscar un cliente
     */
    public Food findFood(int id) throws Exception;
    
    public String createFood(Food food) throws Exception;
}
