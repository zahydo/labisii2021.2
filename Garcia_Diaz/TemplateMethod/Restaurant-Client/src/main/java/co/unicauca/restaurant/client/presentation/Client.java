
package co.unicauca.restaurant.client.presentation;

import co.unicauca.restaurant.client.access.Factory;
import co.unicauca.restaurant.client.access.IFoodAccess;
import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.commons.domain.FoodTypeEnum;

/**
 *
 * @author Anderson Diaz
 */
public class Client {


    public static void main(String[] args) throws Exception {
        IFoodAccess service = Factory.getInstance().getFoodService();
        Food food = service.findFood(1);
        System.out.println(food.toString());
        Food newFood = new Food(4,"arvejas",FoodTypeEnum.PRINCIPIO);
        String respuesta = service.createFood(newFood);
        System.out.println("Response: " + respuesta);
        Food findfood = service.findFood(4);
        System.out.println(findfood.toString());
    }
    
}
