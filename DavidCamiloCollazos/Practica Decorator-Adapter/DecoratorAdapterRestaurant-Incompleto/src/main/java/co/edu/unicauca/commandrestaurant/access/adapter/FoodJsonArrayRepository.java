/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.commandrestaurant.access.adapter;


import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.decorator.CryptFood;
import co.edu.unicauca.commandrestaurant.infra.Utilities;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

/**
 *
 * @author David E
 */
public class FoodJsonArrayRepository{
    
    private static List<String> components;
    
    public FoodJsonArrayRepository() {
        if (components == null) {
            components = new ArrayList<>();
            initData();
        }
    }
    
    private void initData() {
        Gson gson = new Gson();
        components.add(gson.toJson(new CryptFood(1, "Fríjoles", FoodTypeEnum.PRINCIPIO)));
        components.add(gson.toJson(new CryptFood(2, "Sopa de verduras", FoodTypeEnum.ENTRADA)));
        components.add(gson.toJson(new CryptFood(3, "Jugo de mango", FoodTypeEnum.JUGO)));
        
    }
    
    public String getName(){
        return Utilities.deecnode(this.getName());
    }
    
    public Food findById(int id) {
        Gson gson = new Gson();
        for (String comp : components) {
            Food food = gson.fromJson(comp, CryptFood.class);
            if (food.getId() == id) {
                return food;
            }
        }
        return null;
    }


    public List<Food> findAll() {
        Gson gson = new Gson();
        List<Food> auxComp = new ArrayList<>();
        for(String componentAux : components){
            Food auxFood = gson.fromJson(componentAux, CryptFood.class);
            auxComp.add(auxFood);
        }
        return auxComp;
    }
    
    public List<String> listJson() {
        return components;
    }


    public boolean create(Food food) {
        Gson gson = new Gson();
        String name = Utilities.deecnode(food.getName());
        if(name == null){
            name = food.getName();
        }
        String foodJson = gson.toJson(new CryptFood(food.getId(),name , food.getType()));
        components.add(foodJson);
        return true;
    }

    public boolean update(Food food) {
        Gson gson = new Gson();
        for (int i = 0; i < components.size(); i++) {
           Food aux = gson.fromJson(components.get(i), CryptFood.class);
           if (aux.getId() == food.getId()) {
               //Modificamos sus datos
                aux.setName(Utilities.deecnode(food.getName()));
                aux.setType(food.getType());
                String rmp = gson.toJson(aux);
                components.set(i, rmp);
                return true;
           }
        }
        return false;
    }

    public void delete(int id) {
        Gson gson = new Gson();
        int i = 0;
        for (String componentAux : components) {
            Food food = gson.fromJson(componentAux, CryptFood.class);
            if (food.getId() == id) {
                components.remove(i);
                return;
            }
            i++;
        }
    }
    
}
