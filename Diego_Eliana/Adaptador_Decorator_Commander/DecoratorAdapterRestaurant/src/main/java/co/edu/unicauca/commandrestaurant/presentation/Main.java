package co.edu.unicauca.commandrestaurant.presentation;

import co.edu.unicauca.commandrestaurant.domain.FoodCommand;

import co.edu.unicauca.commandrestaurant.domain.CreateCommand;
import co.edu.unicauca.commandrestaurant.domain.BaseFood;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.Invoker;
import co.edu.unicauca.commandrestaurant.domain.decorator.Food;

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
        Food food = new BaseFood(1, "Frijoles", FoodTypeEnum.PRINCIPIO);
        //Crea el comando crear
        FoodCommand cmd = new CreateCommand(food);
        invoker.setCommand(cmd);
        invoker.execute();
        
        //Dehace el comando crear
        invoker.undo();
    }

    // public static void main(String[] args) {
    //     System.out.println("-----Prueba de base food-----");
    //     Food food = new BaseFood(1, "frijoles", FoodTypeEnum.PRINCIPIO);
    //     Food cryptFood = new CryptFood(food);
    //     System.out.println("CriptoFood: "+cryptFood.toString());
    //     System.out.println("decodedName: "+cryptFood.getName());
    // }
    // public static void main(String[] args) {
    //     System.out.println("-----Prueba de base food-----");
    //     Food food = new BaseFood(1, "frijoles", FoodTypeEnum.PRINCIPIO);
    //     Food capitalFood = new CapitalFood(food);
    //     System.out.println("CapitalFood: "+capitalFood.toString());
    //     Food cryptFood = new CryptFood(capitalFood);
    //     System.out.println("CriptoFood: "+cryptFood.toString());
    //     System.out.println("decodedName: "+cryptFood.getName());
    // }
}