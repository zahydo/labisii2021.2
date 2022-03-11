package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.domain.Food;

/**
 * Interface del respositorio de comida
 * @author Libardo Pantoja 
 */
public interface IFoodRepository {
    /**
     * Busca una comida por su id
     * @param id id de la comida
     * @return  objeto de tipo Food
     */
    public Food findFood(String id);
    
    public String createFood(Food food);

}
