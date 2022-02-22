package co.edu.unicauca.commandrestaurant.presentation;

import co.edu.unicauca.commandrestaurant.domain.Command;
import co.edu.unicauca.commandrestaurant.domain.CreateCommand;
import co.edu.unicauca.commandrestaurant.domain.FindByIdCommand;
import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.Invoker;
import co.edu.unicauca.commandrestaurant.domain.UpdateCommand;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
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
        //Crear invocador
        Invoker invoker = new Invoker();
        //Crear comida
        Food food = new Food(10, "Lentejas", FoodTypeEnum.PRINCIPIO);
        //Crear comando 
        Command cmd = new CreateCommand(food);
        invoker.setCommand(cmd);
        invoker.execute();

        //Consultar comida
        cmd = new FindByIdCommand();
        invoker.setCommand(cmd);
        //Pasar parámetros
        FindByIdCommand findByIdCommand = (FindByIdCommand) invoker.getCommand();
        findByIdCommand.setFoodId(10);
        //Ejecutar comando
        invoker.execute();
        Food foodFound = findByIdCommand.getFood();

        assertEquals("Lentejas", foodFound.getName());

        //Dehacer comando 
        invoker.undo();

        cmd = new FindByIdCommand();
        invoker.setCommand(cmd);
        //Pasar parámetros
        findByIdCommand = (FindByIdCommand) invoker.getCommand();
        findByIdCommand.setFoodId(10);
        //Ejecutar comando
        invoker.execute();
        foodFound = findByIdCommand.getFood();

        assertEquals(null, foodFound);

    }

}
