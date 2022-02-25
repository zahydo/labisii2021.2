/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.domain.Food;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose Ricardo
 */
public class FoodRepositoryJsonArrayAdapter implements IFoodRepository {

    FoodJsonArrayRepository adaptedRepository;
    
    public FoodRepositoryJsonArrayAdapter() {
        adaptedRepository = new FoodJsonArrayRepository();
    }
    
    
    @Override
    public Food findById(int id) {
        return adaptedRepository.getById(id);
    }

    @Override
    public List<Food> findAll() {
        Gson gson = new Gson();
        List<Food> foods = new ArrayList<>();
        adaptedRepository.getAll().forEach(token -> { 
            foods.add(gson.fromJson(token, Food.class));
        });
        return foods;
    }

    @Override
    public boolean create(Food food) {
        Food aux = new Food(food.getId(),food.getName(), food.getType());
        return adaptedRepository.add(aux);
    }

    @Override
    public boolean update(Food food) {
        Food aux = new Food(food.getId(),food.getName(), food.getType());
        return adaptedRepository.modify(aux);
    }

    @Override
    public void delete(int id) {
        adaptedRepository.remove(id);
    }
    
    
    
}
