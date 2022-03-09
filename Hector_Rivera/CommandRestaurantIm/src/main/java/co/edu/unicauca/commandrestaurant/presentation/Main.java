
package co.edu.unicauca.commandrestaurant.presentation;

import co.edu.unicauca.commandrestaurant.domain.Command;
import co.edu.unicauca.commandrestaurant.domain.CreateCommand;
import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.Invoker;

/**
 *
 * @author libardo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crear invocador
        Invoker invoker = new Invoker();
        //Crear comida
        Food food = new Food(1, "Frijoles", FoodTypeEnum.PRINCIPIO);
        //Crear comando a crear
        Command cmd = new CreateCommand(food);
        invoker.setCommand(cmd);
        invoker.execute();
        
        //Dehacer comando 
        invoker.undo();

    }
    
}
