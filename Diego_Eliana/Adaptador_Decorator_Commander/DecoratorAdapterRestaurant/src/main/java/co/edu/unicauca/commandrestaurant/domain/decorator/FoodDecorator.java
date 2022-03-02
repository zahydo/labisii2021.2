package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;

// import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;

public abstract class FoodDecorator implements Food {
    protected Food food;

    public FoodDecorator (Food food) {
        this.food = food;
    }

    public String getName() {
        return this.food.getName();
    }
    public void setName(String name) {
        this.food.setName(name);
    }

    public int getId() {
        return food.getId();
    }
    public void setId(int id) {
        food.setId(id);
    }

    public FoodTypeEnum getType() {
        return food.getType();
    }
    public void setType(FoodTypeEnum type) {
        food.setType(type);
    }
}
