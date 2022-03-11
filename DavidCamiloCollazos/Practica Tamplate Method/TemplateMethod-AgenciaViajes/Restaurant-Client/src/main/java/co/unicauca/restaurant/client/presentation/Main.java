/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.unicauca.restaurant.client.presentation;

import co.unicauca.restaurant.client.access.Factory;
import co.unicauca.restaurant.client.access.IFoodAccess;
import co.unicauca.restaurant.client.services.FoodService;
import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.commons.domain.FoodTypeEnum;

/**
 *
 * @author David E
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IFoodAccess service = Factory.getInstance().getFoodService();
        FoodService foodService = new FoodService(service);
        
        try {
            System.out.println("Food Creado con id: "+foodService.createFood(new Food(5, "Frijoles Rojos", FoodTypeEnum.PRINCIPIO)));
            System.out.println("Food Creado con id: "+foodService.createFood(new Food(6, "Nachos con carne", FoodTypeEnum.ENTRADA)));
            System.out.println("Food Creado con id: "+foodService.createFood(new Food(7, "Soncocho", FoodTypeEnum.PRINCIPIO)));
            System.out.println("Food Creado con id: "+foodService.createFood(new Food(8, "Arroz con pollo", FoodTypeEnum.ENTRADA)));
            System.out.println("Food Creado con id: "+foodService.createFood(new Food(9, "Jugo mora", FoodTypeEnum.JUGO)));
            System.out.println("Food Creado con id: "+foodService.createFood(new Food(10, "Jugo mora", FoodTypeEnum.JUGO)));
            
            
            Food food = foodService.findFood("7");
            System.out.println("id: "+food.getId()+" Nombre: "+food.getName()+" Tipo: "+food.getType() );
            food = foodService.findFood("5");
            System.out.println("id: "+food.getId()+" Nombre: "+food.getName()+" Tipo: "+food.getType() );
            food = foodService.findFood("2");
            System.out.println("id: "+food.getId()+" Nombre: "+food.getName()+" Tipo: "+food.getType() );
            food = foodService.findFood("10");
            System.out.println("id: "+food.getId()+" Nombre: "+food.getName()+" Tipo: "+food.getType() );
            
        } catch (Exception e) {
        }
        
    }
    
}
