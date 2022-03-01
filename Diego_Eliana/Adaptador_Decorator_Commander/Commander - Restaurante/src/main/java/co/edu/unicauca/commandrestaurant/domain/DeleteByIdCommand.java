package co.edu.unicauca.commandrestaurant.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.access.RepositoryFactory;
import co.edu.unicauca.commandrestaurant.domain.service.FoodService;

public class DeleteByIdCommand extends Command {
    /**
     * Comida a eliminar
     */
    private Food food;
    /**
     * Instancia al receptor
     */
    private FoodService service;

    /**
     * Constructor
     */
    public DeleteByIdCommand(Food food) {
        this.food = food;
        IFoodRepository repo = RepositoryFactory.getInstance().getRepository("default");
        service = new FoodService(repo);
        this.hasUndo = true;
    }

    public void setDeletedFood(Food food) {
        this.food = food;
    }

    public Food getDeletedFood() {
        return food;
    }

    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(DeleteByIdCommand.class); 
        logger.info("Comando de eliminar comida se ha ejecutado. Id " + food.getId());          
        service.delete(food.getId());
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(DeleteByIdCommand.class); 
        logger.info("Comando de edición se ha deshecho. Se grabó la comida " + food);             
        service.undoDelete(food);
    }
}
