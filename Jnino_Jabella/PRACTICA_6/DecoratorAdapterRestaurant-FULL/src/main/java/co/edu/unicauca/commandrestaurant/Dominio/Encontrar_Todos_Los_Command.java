package co.edu.unicauca.commandrestaurant.Dominio;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Comando concreto para buscar todas las comidas
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class Encontrar_Todos_Los_Command extends Command_Comida {

    /**
     * Lista de comidas, resultado de ejecutar el comando
     */
    private List<Comida> foods;
    /**
     * Instancia del receptor
     */
    public Encontrar_Todos_Los_Command() {
        super();
        foods = new ArrayList<>();
        this.hasUndo = false;
    }

    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(Encontrar_Todos_Los_Command.class); 
        logger.info("Comando de buscar todas las comidas ejecutado." );            
        foods = service.findAll();
        //System.out.println("No hay foods");
    }

    public List<Comida> getFoods() {
        return foods;
    }

    @Override
    public void undo() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
