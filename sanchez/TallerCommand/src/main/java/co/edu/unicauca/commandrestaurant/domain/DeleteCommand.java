package co.edu.unicauca.commandrestaurant.domain;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.access.RepositoryFactory;
import co.edu.unicauca.commandrestaurant.domain.service.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Juan Sebastian Sanchez Pizo
 */
public class DeleteCommand extends Command{

    /**
     * Comida a ser eliminada
     */
    private Food food;
    
    /**
     * comida previa, que permitirá deshacer la operación de eliminar
     */ 
    private Food foodPrevious;
    
    /**
     * Instancia al receptor
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
        Logger logger= LoggerFactory.getLogger(DeleteCommand.class); 
        logger.info("Comando de eliminación se ha ejecutado. Se eliminó la comida " + food);            
        service.delete(food.getId());
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(DeleteCommand.class); 
        logger.info("Comando de eliminación se ha deshecho. no se eliminó la comida " + foodPrevious);             
        service.create(foodPrevious);
    }
    
    public Food getFoodPrevious() {
        return foodPrevious;
    }

    public void setFoodPrevious(Food componentPrevious) {
        this.foodPrevious = componentPrevious;
    }
    
}
