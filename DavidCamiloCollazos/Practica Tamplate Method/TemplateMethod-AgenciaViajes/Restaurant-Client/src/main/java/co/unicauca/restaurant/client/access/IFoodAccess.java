/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.restaurant.client.access;
import co.unicauca.restaurant.commons.domain.Food;

/**
 *
 * @author David E
 */
public interface IFoodAccess {

    /**
     * Crea una Food
     *
     * @param food comida del restaurante
     * @return devuelve el id del plato
     * @throws Exception error crear la comida
     */
    public String createFood(Food food) throws Exception;
    
    /**
     * Busca una Food por su id
     * @param id id de la comida
     * @return devuelve la comida
     * @throws Exception Error al buscar la comida
     */
    public Food findFood(String id) throws Exception;
}
