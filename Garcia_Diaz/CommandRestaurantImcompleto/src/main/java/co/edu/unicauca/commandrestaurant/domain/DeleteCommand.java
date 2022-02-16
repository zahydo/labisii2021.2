
package co.edu.unicauca.commandrestaurant.domain;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.access.RepositoryFactory;
import co.edu.unicauca.commandrestaurant.domain.service.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Dz
 */
public class DeleteCommand extends Command{

    /**
     * Comida a eliminar
     */
    private Food food;
    private Food foodPrevious;
    /**
     * id de la comida a buscar
     */
    private int foodId;
    /**
     * Instancia al receptor
     */
    private FoodService service;

    /**
     * Constructor
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
        logger.info("Comando de ELIMINAR. Se elimino la comida:  " + food.toString());          
        service.delete(foodId);
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(DeleteCommand.class); 
        logger.info("Comando de Eliminacion deshecho. Se restablecio la comida " + food.toString());        
        service.create(foodPrevious);
    }
    
    public int getFoodId() {
        return foodId;
    }
    
    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
    
    public void setFoodPrevious(Food componentPrevious) {
        this.foodPrevious = componentPrevious;
    }

    public Food getFood() {
        return food;
    }
}
