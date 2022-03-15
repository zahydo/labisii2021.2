package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.common.domain.Food;

public interface IFoodAccess {

    public String createFood(Food food) throws Exception;
    public Food findFood(String id) throws Exception;
    
}
