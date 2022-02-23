/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.decorator.CapitalFood;
import co.edu.unicauca.commandrestaurant.domain.decorator.CryptFood;
import co.edu.unicauca.commandrestaurant.infra.Utilities;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mandr
 */
public class FoodJsonArrayRepository {
    private static List<String> foods;

    public FoodJsonArrayRepository() {
        if (foods == null) {
            foods = new ArrayList<>();
            initData();
        }
    }
    
    private void initData() {        
        Gson gson = new Gson();
        
        String json = gson.toJson(new CryptFood(1, "Fríjoles", FoodTypeEnum.PRINCIPIO));
        foods.add(json);
        json = gson.toJson(new CryptFood(2, "Sopa de verduras", FoodTypeEnum.ENTRADA));
        foods.add(json);
        json = gson.toJson(new CryptFood(3, "Jugo de mango", FoodTypeEnum.JUGO));
        foods.add(json);

    }
    
    public boolean add(Food food){
        Gson gson = new Gson();
        String json = gson.toJson(new CryptFood(food.getId(), food.getName(), food.getType()));
        foods.add(json);
        return true;
        
    }
    
    public List<Food> getAll(){
        Gson gson = new Gson();
        List<Food> list = new ArrayList();
        
        for (int i = 0; i < foods.size(); i++) {
            Food f = gson.fromJson(foods.get(i), CryptFood.class);
            list.add(f);
        }
        return list;
    }
    
    public Food getFood(int id){
        Gson gson = new Gson();
        
        for (int i = 0; i < foods.size(); i++) {
            Food f = gson.fromJson(foods.get(i), CryptFood.class);
            if(id == f.getId()){
                f.setName(Utilities.getAESDecrypt(f.getName()));
                return f;
            }
        }
        return null;
    }
    
    public boolean updateFood(Food food){
        Gson gson = new Gson();
        
        for (int i = 0; i < foods.size(); i++) {
            Food f = gson.fromJson(foods.get(i), CryptFood.class);
            if(food.getId() == f.getId()){
                String json = gson.toJson(new CryptFood(food.getId(), food.getName(), food.getType()));
                foods.set(i, json);
                return true;
            }
        }
        return false;
    }
    
    public void deleteFood(int id){
        Gson gson = new Gson();
        
        for (int i = 0; i < foods.size(); i++) {
            Food f = gson.fromJson(foods.get(i), CryptFood.class);
            if(id == f.getId()){
                foods.remove(i);
            }
        }
    }
    
    
    
}
