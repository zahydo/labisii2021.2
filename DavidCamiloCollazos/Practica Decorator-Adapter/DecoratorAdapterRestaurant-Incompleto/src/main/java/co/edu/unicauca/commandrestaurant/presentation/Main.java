
package co.edu.unicauca.commandrestaurant.presentation;

import co.edu.unicauca.commandrestaurant.domain.FoodCommand;
import co.edu.unicauca.commandrestaurant.domain.CreateCommand;
import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.Invoker;
import com.google.gson.Gson;

/**
 *
 * @author libardo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crea el invocador
        Invoker invoker = new Invoker();
        //Crea la comida
        Food food = new Food(1, "Frijoles", FoodTypeEnum.PRINCIPIO);
        
        Gson gson = new Gson();
        String foodJson = gson.toJson(food);
        System.out.println(foodJson);
        
        //Crea el comando crear
        FoodCommand cmd = new CreateCommand(food);
        invoker.setCommand(cmd);
        invoker.execute();
        
        //Dehace el comando crear
        invoker.undo();

    }
    
}
