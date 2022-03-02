package co.edu.unicauca.commandrestaurant.access.adapter;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.domain.decorator.Food;

public class FoodRepositoryJsonArrayAdapter implements IFoodRepository {
    /**
     * Repositorio adaptado
     */
    FoodJsonArrayRepository adaptedRepository;
    Gson gson;
    /**
     * Constructor
     */
    public FoodRepositoryJsonArrayAdapter() {
        adaptedRepository = new FoodJsonArrayRepository();
        gson = new Gson();
    }

    @Override
    public Food findById(int id) {
        String obj = "{\"id\":"+id+"}";
        JsonObject jsonSentense = JsonParser.parseString(obj).getAsJsonObject();
        return adaptedRepository.getById(jsonSentense);
    }

    @Override
    public boolean create(Food food) {
        String str = gson.toJson(food);
        JsonObject jsonSentense = JsonParser.parseString(str).getAsJsonObject();
        return adaptedRepository.add(jsonSentense);
    }

    @Override
    public boolean update(Food food) {
        String str = gson.toJson(food);
        JsonObject jsonSentense = JsonParser.parseString(str).getAsJsonObject();
        return adaptedRepository.modify(jsonSentense);
    }

    @Override
    public void delete(int id) {
        String obj = "{\"id\":"+id+"}";
        JsonObject jsonSentense = JsonParser.parseString(obj).getAsJsonObject();
        adaptedRepository.remove(jsonSentense);
    }
    
    @Override
    public List<Food> findAll() {
        List<String> jsons = adaptedRepository.getAll();
        List<Food> foodList = new ArrayList<Food>();
        for (String jsonFood : jsons) {
            foodList.add(gson.fromJson(jsonFood,  Food.class));
        }
        return foodList;
    }

    @Override
    public boolean undoDelete(Food food) {
        String str = gson.toJson(food);
        JsonObject jsonSentense = JsonParser.parseString(str).getAsJsonObject();
        return adaptedRepository.add(jsonSentense);
    }
}
