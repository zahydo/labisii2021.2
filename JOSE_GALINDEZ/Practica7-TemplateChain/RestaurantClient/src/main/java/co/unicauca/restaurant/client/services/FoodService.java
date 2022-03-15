package co.unicauca.restaurant.client.services;

import co.unicauca.restaurant.client.access.IFoodAccess;
import co.unicauca.restaurant.common.domain.Food;


public class FoodService {

    private final IFoodAccess service;


    public FoodService(IFoodAccess service) {
        this.service = service;
    }


    public String createFood(Food food) throws Exception {
        return service.createFood(food);
    }

    public Food findFood(String id) throws Exception {
        return service.findFood(id);
    }

}
