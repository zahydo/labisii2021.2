package co.edu.unicauca.commandrestaurant.presentation;

import co.edu.unicauca.commandrestaurant.domain.FoodCommand;
import co.edu.unicauca.commandrestaurant.domain.BaseFood;
import co.edu.unicauca.commandrestaurant.domain.CreateCommand;
import co.edu.unicauca.commandrestaurant.domain.FindByIdCommand;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.Invoker;
import co.edu.unicauca.commandrestaurant.domain.decorator.Food;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Libardo, Julio
 */
public class CommandTest {

    @Test
    public void testCreateCommand() {
        System.out.println("CreateCommand");
        //Crea el invocador
        Invoker invoker = new Invoker();
        //Crea la comida
        Food food = new BaseFood(10, "Lentejas", FoodTypeEnum.PRINCIPIO);
        //Crea el comando crear
        FoodCommand cmd = new CreateCommand(food);
        invoker.setCommand(cmd);
        invoker.execute();

        //Consulta la comida
        cmd = new FindByIdCommand();
        invoker.setCommand(cmd);
        //Pasa parámetros al comando
        FindByIdCommand findByIdCommand = (FindByIdCommand) invoker.getCommand();
        findByIdCommand.setFoodId(10);
        //Ejecuta el comando
        invoker.execute();
        Food foodFound = findByIdCommand.getFood();

        assertEquals("Lentejas", foodFound.getName());

        //Dehace el comando crear
        invoker.undo();

        cmd = new FindByIdCommand();
        invoker.setCommand(cmd);
        //Pasa parámetros al comando
        findByIdCommand = (FindByIdCommand) invoker.getCommand();
        findByIdCommand.setFoodId(10);
        //Ejecuta el comando
        invoker.execute();
        foodFound = findByIdCommand.getFood();

        assertEquals(null, foodFound);

    }

}
