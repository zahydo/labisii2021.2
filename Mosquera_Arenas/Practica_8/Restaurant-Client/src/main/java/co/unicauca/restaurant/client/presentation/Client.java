/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.unicauca.restaurant.client.presentation;

import co.unicauca.restaurant.client.access.Factory;
import co.unicauca.restaurant.client.access.IFoodAccess;
import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.commons.domain.FoodTypeEnum;

/**
 *
 * @author Sebastian_Arenas
 */
public class Client {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        IFoodAccess service = Factory.getInstance().getFoodService();
        Food food = service.findFood(1);
        System.out.println(food.toString());
        Food newFood = new Food(4,"Lentejas",FoodTypeEnum.PRINCIPIO);
        String respuesta = service.createFood(newFood);
        System.out.println("Response: " + respuesta);
        Food findfood = service.findFood(4);
        System.out.println(findfood.toString());
    }
    
}
