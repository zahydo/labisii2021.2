package co.unicauca.restaurant.client.presentation;

import co.unicauca.restaurant.client.access.Factory;
import co.unicauca.restaurant.client.access.IFoodAccess;
import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.commons.domain.FoodTypeEnum;
import co.unicauca.restaurant.client.services.FoodService;

/**
 *
 * @author XssIsor
 */
public class MainClass {
    
    /**
     * Ejecución del cliente para que muestre el funcionamiento.
     * @param args 
     */
    public static void main(String[] args) {
        IFoodAccess service = Factory.getInstance().getFoodService();
        FoodService foodService = new FoodService(service);

        try {
            System.out.println("Comida Creada con Identificador: "+foodService.create(new Food(4, "Flan de Coco", FoodTypeEnum.POSTRE)));
            System.out.println("Comida Creada con Identificador: "+foodService.create(new Food(6, "Pan Duro", FoodTypeEnum.ENTRADA)));
            System.out.println("Comida Creada con Identificador: "+foodService.create(new Food(8, "Cerdo Entero", FoodTypeEnum.CARNE)));


            Food newFood = foodService.findFood("1");
            System.out.println("Comida encontrada. id: "+newFood.getId()+" Nombre: "+newFood.getName());
            newFood = foodService.findFood("3");
            System.out.println("Comida encontrada. id: "+newFood.getId()+" Nombre: "+newFood.getName());
            newFood = foodService.findFood("4");
            System.out.println("Comida encontrada. id: "+newFood.getId()+" Nombre: "+newFood.getName());
            newFood = foodService.findFood("8");
            System.out.println("Comida encontrada. id: "+newFood.getId()+" Nombre: "+newFood.getName());
            
        } catch (Exception e) {
        }

    }
}
