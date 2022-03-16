
package co.unicauca.restaurant.client.domain.services;

import co.unicauca.restaurant.client.access.IFoodAccess;
import co.unicauca.restaurant.commons.domain.Food;


/**
 *
 * @author Anderson Diaz
 */
public class FoodService {
    private final IFoodAccess service;
    
    public FoodService(IFoodAccess service) {
        this.service = service;
    }
    
    
    public Food findFood(int id) throws Exception {
        return service.findFood(id);

    }
    
    public String createFood(Food food) throws Exception {
        return service.createFood(food);

    }
}
