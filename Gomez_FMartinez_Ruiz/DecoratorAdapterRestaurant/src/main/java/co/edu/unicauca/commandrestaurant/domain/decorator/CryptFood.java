/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.infra.Utilities;

/**
 *
 * @author XssIsor
 */
public class CryptFood extends Food{

    private Food cryptFood;

    public CryptFood(int id, String name, FoodTypeEnum type) {
    	String encryptedFoodName = Utilities.encrypt(name);
        cryptFood = new Food(id, encryptedFoodName, type);
    }

    @Override
    public String getName() {
        return cryptFood.getName();
    }
    
    @Override
    public void setName(String name) {
        cryptFood.setName(Utilities.encrypt(name));
    }
    
    @Override
    public int getId() {
        return cryptFood.getId();
    }

    @Override
    public void setId(int id) {
        cryptFood.setId(id);
    }

    @Override
    public FoodTypeEnum getType() {
        return cryptFood.getType();
    }

    @Override
    public void setType(FoodTypeEnum type) {
        cryptFood.setType(type);
    }

    @Override
    public String toString() {
        return "Food{" + "id: " + cryptFood.getId() + ", name: " + cryptFood.getName() + ", type: " + cryptFood.getType() + "}";
    }
}
