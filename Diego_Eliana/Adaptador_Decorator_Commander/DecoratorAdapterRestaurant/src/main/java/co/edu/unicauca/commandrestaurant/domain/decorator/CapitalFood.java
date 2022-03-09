package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.infra.Utilities;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class CapitalFood extends FoodDecorator {

    public CapitalFood(Food food) {
        super(food);
        setName(this.food.getName());
    }

    @Override
    public void setName(String name) {
        this.food.setName(Utilities.capitalize(name));
    }

    @Override
    public String toString() {
        return this.food.toString();
    }
}
