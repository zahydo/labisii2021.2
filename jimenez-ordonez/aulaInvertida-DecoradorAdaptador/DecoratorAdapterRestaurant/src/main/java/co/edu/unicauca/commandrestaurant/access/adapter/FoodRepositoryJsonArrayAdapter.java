package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.decorator.CapitalFood;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jandresordonez
 */
public class FoodRepositoryJsonArrayAdapter implements IFoodRepository {

    /**
     * Repositorio adaptado
     */
    FoodJsonArrayRepository adaptedRepository;

    /**
     * Constructor
     */
    public FoodRepositoryJsonArrayAdapter() {
        adaptedRepository = new FoodJsonArrayRepository();
    }

    @Override
    public Food findById(int id) {
        return adaptedRepository.getById(id);
    }

    @Override
    public List<Food> findAll() { 
        Gson g = new Gson();
        List<String> foods = adaptedRepository.getAll();
        List<Food> list = new ArrayList();
        foods.forEach((String food) -> {
            list.add(g.fromJson(food, CapitalFood.class));
        });
        return list;
    }

    @Override
    public boolean create(Food food) {
        return adaptedRepository.add(food);
    }

    @Override
    public boolean update(Food food) {
        return adaptedRepository.modify(food);
    }

    @Override
    public void delete(int id) {
        adaptedRepository.remove(id);
    }
    
}
