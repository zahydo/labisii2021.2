package co.edu.unicauca.commandrestaurant.domain;

import co.edu.unicauca.commandrestaurant.domain.service.FoodService;
import co.edu.unicauca.commandrestaurant.access.RepositoryFactory;
import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Comando concreto para modificar una comida
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class DeleteCommand extends Command {

    /**
     * Comida a ser eliminada
     */
    private Food food;
    /**
     * Instancia del receptor
     */
    private FoodService service;

    /**
     * Constructor parametrizado
     * @param food comida a eliminar
     */
    public DeleteCommand(Food food) {
        this.food = food;
        IFoodRepository repo = RepositoryFactory.getInstance().getRepository("default");
        service = new FoodService(repo);
        this.hasUndo = true;
    }

    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(UpdateCommand.class); 
        logger.info("Comando de eliminación se ha ejecutado. Se eliminó la comida " + food);            
        service.delete(food.getId());
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(UpdateCommand.class); 
        logger.info("Comando de eliminación se ha deshecho. Se restauró la comida " + food);             
        service.create(food);
    }

    
}
