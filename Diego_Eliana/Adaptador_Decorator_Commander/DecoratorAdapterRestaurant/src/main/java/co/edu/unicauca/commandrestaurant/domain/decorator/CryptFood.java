package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.service.SecurityService;

public class CryptFood extends FoodDecorator {

    public CryptFood(Food food) {
        super(food);
        this.food.setName(SecurityService.encript(food.getName()));
    }

    @Override
    public void setName(String name) {
        this.food.setName(name);
    }
    
    @Override
    public String toString() {
        return this.food.toString();
    }
}
