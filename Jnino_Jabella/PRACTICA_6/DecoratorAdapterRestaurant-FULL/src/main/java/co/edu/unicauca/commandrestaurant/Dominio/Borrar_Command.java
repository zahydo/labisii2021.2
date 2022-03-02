package co.edu.unicauca.commandrestaurant.Dominio;

import co.edu.unicauca.commandrestaurant.Dominio.Servicios.FoodService;
import co.edu.unicauca.commandrestaurant.Acceso.RepositoryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import co.edu.unicauca.commandrestaurant.Acceso.Interface_ComidaRepository;

/**
 * Comando concreto para eliminar una comida
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class Borrar_Command extends Command_Comida {

    /**
     * Comida que se graba para poder deshacer
     */
    private Comida food;
    /**
     * Instancia al receptor
     */
    private FoodService service;

    public Borrar_Command(Comida food) {
        this.food = food;
        Interface_ComidaRepository repo = RepositoryFactory.getInstance().getRepository();
        service = new FoodService(repo);
        this.hasUndo = true;
    }

    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(Borrar_Command.class); 
        logger.info("Comando de eliminación ejecutado. Se eliminó la comida " + food.toString());        
        service.delete(food.getId());
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(Borrar_Command.class); 
        logger.info("Comando de eliminación deshecho. Se creó la comida " + food.toString());            
        service.create(food);
    }

}
