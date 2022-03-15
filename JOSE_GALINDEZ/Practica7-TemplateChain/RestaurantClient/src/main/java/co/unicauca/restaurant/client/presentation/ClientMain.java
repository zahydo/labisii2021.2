/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.unicauca.restaurant.client.presentation;

import co.unicauca.restaurant.client.access.Factory;
import co.unicauca.restaurant.client.access.IFoodAccess;
import co.unicauca.restaurant.client.services.FoodService;
import co.unicauca.restaurant.common.domain.Food;

/**
 *
 * @author Jose Ricardo
 */
public class ClientMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        IFoodAccess service = Factory.getInstance().getFoodService();
        FoodService foodService = new FoodService(service);


        System.out.println("Creado plato con id: " + foodService.createFood(new Food(4, "Comida 4")));
        System.out.println("Creado plato con id: " + foodService.createFood(new Food(5, "Comida 5")));
        System.out.println("Creado plato con id: " + foodService.createFood(new Food(6, "Comida 6")));

        
        
        Food food = foodService.findFood("4");
        System.out.println("\nid: " + food.getId() + " Nombre: " + food.getName());
        food = foodService.findFood("5");
        System.out.println("\nid: " + food.getId() + " Nombre: " + food.getName());
        food = foodService.findFood("6");
        System.out.println("\nid: " + food.getId() + " Nombre: " + food.getName());

    }

}
