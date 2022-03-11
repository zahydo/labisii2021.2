package co.unicauca.restaurant.client.presentation;

import co.unicauca.Restaurant.commons.domain.Food;
import co.unicauca.Restaurant.commons.domain.FoodTypeEnum;
import co.unicauca.restaurant.client.access.Factory;
import co.unicauca.restaurant.client.access.IFoodAccess;
import co.unicauca.restaurant.client.domain.services.FoodService;

public class Main {

	public static void main(String[] args) {
		IFoodAccess foodAccess = Factory.getInstance().getFoodService();
		FoodService foodService = new FoodService(foodAccess);
		
		try {
			System.out.println("Encontrar Food en server");
			Food food;
			food = foodService.findFood("1");
			System.out.println("Id: "+food.getId()+" Nombre: "+food.getName()+" Tipo: "+food.getType());
			food = foodService.findFood("2");
			System.out.println("Id: "+food.getId()+" Nombre: "+food.getName()+" Tipo: "+food.getType());
			food = foodService.findFood("3");
			System.out.println("Id: "+food.getId()+" Nombre: "+food.getName()+" Tipo: "+food.getType());
			
			System.out.println("Agregar Food en server");
			
			System.out.println("Food Creado con id: "+foodService.createFood(new Food(4,"Stroganov",FoodTypeEnum.CARNE)));
			System.out.println("Food Creado con id: "+foodService.createFood(new Food(5,"Limonada",FoodTypeEnum.JUGO)));
			System.out.println("Food Creado con id: "+foodService.createFood(new Food(6,"Red Velvet",FoodTypeEnum.POSTRE)));
			System.out.println("Food Creado con id: "+foodService.createFood(new Food(7,"Gnocchi",FoodTypeEnum.ENTRADA)));

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
