package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.domain.Food;


/**
 *
 * @author XssIsor
 */
public interface IFoodRepository {

    /**
     * Busca una comida por ID
     * @param id int. identificador de la comida a buscar
     * @return comida Food
     */
    public Food findById(int id);
    
    
     /**
     * Agrega una nueva comida 
     * @param food Food. La comida a agregar
     * @return El identificador con de la comida agregada
     */
    public String create(Food food);

}
