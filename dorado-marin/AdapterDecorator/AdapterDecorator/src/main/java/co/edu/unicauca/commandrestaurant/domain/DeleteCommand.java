package co.edu.unicauca.commandrestaurant.domain;

import co.edu.unicauca.commandrestaurant.domain.service.FoodService;
import co.edu.unicauca.commandrestaurant.access.RepositoryFactory;
import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Comando concreto para eliminar una comida
 *
 * @author Fabián David Marín y Héctor Fernando Dorado
 */
public class DeleteCommand extends FoodCommand {

    /**
     * Comida que se graba para poder deshacer
     */
    private Food food;
    /**
     * Instancia al receptor
     */
    private FoodService service;

    public DeleteCommand(Food food) {
        this.food = food;
        IFoodRepository repo = RepositoryFactory.getInstance().getRepository();
        service = new FoodService(repo);
        this.hasUndo = true;
    }

    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(DeleteCommand.class); 
        logger.info("Comando de eliminación ejecutado. Se eliminó la comida " + food.toString());        
        service.delete(food.getId());
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(DeleteCommand.class); 
        logger.info("Comando de eliminación deshecho. Se creó la comida " + food.toString());            
        service.create(food);
    }

}
