package co.edu.unicauca.commandrestaurant.presentation;

import co.edu.unicauca.commandrestaurant.Dominio.Command_Comida;
import co.edu.unicauca.commandrestaurant.Dominio.Crear_Command;
import co.edu.unicauca.commandrestaurant.Dominio.Encontrar_Command_ID;
import co.edu.unicauca.commandrestaurant.Dominio.Comida;
import co.edu.unicauca.commandrestaurant.Dominio.Tipo_ComidaEnum;
import co.edu.unicauca.commandrestaurant.Dominio.Invoker;
import co.edu.unicauca.commandrestaurant.Dominio.Actualizar_Command;
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
        //Crea el invocador
        Invoker invoker = new Invoker();
        //Crea la comida
        Comida food = new Comida(10, "Lentejas", Tipo_ComidaEnum.PRINCIPIO);
        //Crea el comando crear
        Command_Comida cmd = new Crear_Command(food);
        invoker.setCommand(cmd);
        invoker.execute();

        //Consulta la comida
        cmd = new Encontrar_Command_ID();
        invoker.setCommand(cmd);
        //Pasa parámetros al comando
        Encontrar_Command_ID findByIdCommand = (Encontrar_Command_ID) invoker.getCommand();
        findByIdCommand.setFoodId(10);
        //Ejecuta el comando
        invoker.execute();
        Comida foodFound = findByIdCommand.getFood();

        assertEquals("Lentejas", foodFound.getNombre());

        //Dehace el comando crear
        invoker.undo();

        cmd = new Encontrar_Command_ID();
        invoker.setCommand(cmd);
        //Pasa parámetros al comando
        findByIdCommand = (Encontrar_Command_ID) invoker.getCommand();
        findByIdCommand.setFoodId(10);
        //Ejecuta el comando
        invoker.execute();
        foodFound = findByIdCommand.getFood();

        assertEquals(null, foodFound);

    }

}
