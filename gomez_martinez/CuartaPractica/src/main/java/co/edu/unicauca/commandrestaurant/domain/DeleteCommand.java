package co.edu.unicauca.commandrestaurant.domain;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.access.RepositoryFactory;
import co.edu.unicauca.commandrestaurant.domain.service.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author maria
 */
public class DeleteCommand extends Command{
    /**
     *  Servicio de receptor
     */
    private FoodService service;
    /**
     * comida a crear o eliminar
     */
    private Food food;



    public DeleteCommand(Food food) {
        this.food = food;
        IFoodRepository repo = RepositoryFactory.getInstance().getRepository("default");
        service = new FoodService(repo);
        this.hasUndo = true;
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(UpdateCommand.class); 
        logger.info("El comando se ejecutó correctamente. Se restauró la comida " + food);
        service.create(food);
    }
    
    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(UpdateCommand.class); 
        logger.info("El comando se ejecutó correctamente. Se eliminó la comida " + food);
        service.delete(food.getId());
    }

   
}
