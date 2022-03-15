package co.unicauca.restaurant.server.app.access;

import co.unicauca.restaurant.common.domain.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodRepositoryImplArrays implements IFoodRepository {

    private static List<Food> components;

    public FoodRepositoryImplArrays() {
        if (components == null) {
            components = new ArrayList<>();
            initData();
        }
    }

    private void initData() {
        components.add(new Food(1, "Comida 1"));
        components.add(new Food(2, "Comida 2"));
        components.add(new Food(3, "Comida 3"));
    }

    @Override
    public Food findById(int id) {
        for (Food comp : components) {
            if (comp.getId() == id) {
                return comp;
            }
        }
        return null;
    }

    @Override
    public String create(Food component) {
        components.add(component);
        return String.valueOf(component.getId());
    }
}
