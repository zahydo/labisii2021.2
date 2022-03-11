package co.unicauca.travelagency.client.presentation;

import co.unicauca.travelagency.client.access.Factory;
import co.unicauca.travelagency.client.access.IFoodAccess;
import co.unicauca.travelagency.client.domain.services.FoodService;
import co.unicauca.travelagency.commons.domain.Food;
import co.unicauca.travelagency.commons.domain.FoodTypeEnum;

public class Main {
  public static void main(String[] args) throws Exception {
    IFoodAccess service = Factory.getInstance().getFoodService();
    FoodService foodService = new FoodService(service);

    System.out.println(
        "Food Creado con id: " + foodService.createFood(new Food(4, "Frijoles test 1", FoodTypeEnum.PRINCIPIO)));
    System.out.println(
        "Food Creado con id: " + foodService.createFood(new Food(5, "Frijoles test 2", FoodTypeEnum.ENTRADA)));
    System.out.println(
        "Food Creado con id: " + foodService.createFood(new Food(6, "Frijoles test 3", FoodTypeEnum.CARNE)));

    Food food = foodService.findFood("4");
    System.out.println("\nid: " + food.getId() + " Nombre: " + food.getName() + " Tipo: " + food.getType());
    food = foodService.findFood("5");
    System.out.println("\nid: " + food.getId() + " Nombre: " + food.getName() + " Tipo: " + food.getType());
    food = foodService.findFood("6");
    System.out.println("\nid: " + food.getId() + " Nombre: " + food.getName() + " Tipo: " + food.getType());
  }
}
