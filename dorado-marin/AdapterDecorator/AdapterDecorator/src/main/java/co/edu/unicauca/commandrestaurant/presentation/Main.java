package co.edu.unicauca.commandrestaurant.presentation;

import co.edu.unicauca.commandrestaurant.domain.FoodCommand;
import co.edu.unicauca.commandrestaurant.domain.CreateCommand;
import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.Invoker;

/**
 * Ejecución secundaria del programa por consola 
 *
 * @author Fabián David Marín y Héctor Fernando Dorado
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crea el invocador\
        new GUIFood().setVisible(true);
        Invoker invoker = new Invoker();
        //Crea la comida
        Food food = new Food(1, "Frijoles", FoodTypeEnum.PRINCIPIO);
        //Crea el comando crear
        FoodCommand cmd = new CreateCommand(food);
        invoker.setCommand(cmd);
        invoker.execute();
        
        //Dehace el comando crer
        invoker.undo();

    }
    
}
