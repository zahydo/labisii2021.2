
package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.domain.Food;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author @author Libardo Pantoja, Julio A. Hurtado
 */
public class FoodRepositoryJsonArrayAdapter implements IFoodRepository {

    FoodJsonArrayRepository adaptedJsonRepository;
    
    public FoodRepositoryJsonArrayAdapter() {
        adaptedJsonRepository = new FoodJsonArrayRepository();
    }
    
    
    @Override
    public Food findById(int id) {
        return adaptedJsonRepository.getById(id);
    }

    @Override
    public List<Food> findAll() {
        Gson gson = new Gson();
        List<Food> foods = new ArrayList<>();
        adaptedJsonRepository.getAll().forEach(token -> { 
            foods.add(gson.fromJson(token, Food.class));
        });
        return foods;
    }

    @Override
    public boolean create(Food food) {
        Food aux = new Food(food.getId(),food.getName(), food.getType());
        return adaptedJsonRepository.add(aux);
    }

    @Override
    public boolean update(Food food) {
        Food aux = new Food(food.getId(),food.getName(), food.getType());
        return adaptedJsonRepository.modify(aux);
    }

    @Override
    public void delete(int id) {
        adaptedJsonRepository.remove(id);
    }
    
    
    
}
