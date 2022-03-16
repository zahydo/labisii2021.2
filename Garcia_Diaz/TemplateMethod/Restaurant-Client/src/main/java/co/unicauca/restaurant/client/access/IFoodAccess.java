
package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.commons.domain.Food;

/**
 *
 * @author Anderson Diaz
 */
public interface IFoodAccess {
 
    public Food findFood(int id) throws Exception;
    
    public String createFood(Food food) throws Exception;
}
