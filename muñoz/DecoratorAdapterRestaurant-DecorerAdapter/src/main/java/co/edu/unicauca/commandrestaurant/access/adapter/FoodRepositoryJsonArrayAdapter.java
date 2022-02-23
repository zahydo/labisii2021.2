/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.access.FoodJsonArrayRepository;
import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.domain.Food;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class FoodRepositoryJsonArrayAdapter implements IFoodRepository {
    
    private FoodJsonArrayRepository repo;  
    private Gson json;  
    
    public FoodRepositoryJsonArrayAdapter() throws Exception{
        repo = new FoodJsonArrayRepository();  
        json = new Gson();  
    }
    
    @Override
    public Food findById(int id) {
        String food = repo.getById(id); 
        if(food == null){
           return null; 
        }
        return json.fromJson(food, Food.class); 
    }

    @Override
    public List<Food> findAll() {
        List<Food> elements = new ArrayList(); 
        ArrayList<String> foods = repo.getAll(); 
        for(String aux: foods){
            elements.add(json.fromJson(aux, Food.class));
        }
        return elements;  
    }

    @Override
    public boolean create(Food food) {
        return repo.add(json.toJson(food));  
    }

    @Override
    public boolean update(Food food) {
        return repo.modify(json.toJson(food)); 
    }

    @Override
    public void delete(int id) {
        repo.remove(id);
    }
    
}
