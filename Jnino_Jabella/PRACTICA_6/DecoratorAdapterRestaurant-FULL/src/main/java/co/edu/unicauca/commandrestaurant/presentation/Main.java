
package co.edu.unicauca.commandrestaurant.presentation;

import co.edu.unicauca.commandrestaurant.Dominio.Command_Comida;
import co.edu.unicauca.commandrestaurant.Dominio.Crear_Command;
import co.edu.unicauca.commandrestaurant.Dominio.Comida;
import co.edu.unicauca.commandrestaurant.Dominio.Tipo_ComidaEnum;
import co.edu.unicauca.commandrestaurant.Dominio.Invoker;

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
        Comida food = new Comida(1, "Frijoles Negros", Tipo_ComidaEnum.PRINCIPIO);
        //Crea el comando crear
        Command_Comida cmd = new Crear_Command(food);
        invoker.setCommand(cmd);
        invoker.execute();
        
        //Dehace el comando crear
        invoker.undo();

    }
    
}
