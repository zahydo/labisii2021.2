
package co.edu.unicauca.commandrestaurant.domain;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.access.RepositoryFactory;
import co.edu.unicauca.commandrestaurant.domain.service.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jnino, jabella
 */
public class DeleteCommand extends Command{

    /**
     * Comida que se va a eliminar
     */
    private Food food;
    private Food copyFoodAnt;
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
        logger.info("Comando de eliminar. Se elimino la comida corectamente:  " + food.toString());          
        service.delete(foodId);
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(DeleteCommand.class); 
        logger.info("Comando de eliminacion deshecho. Se restablecio la comida correctamente " + food.toString());        
        service.create(copyFoodAnt);
    }
    
    public int getFoodId() {
        return foodId;
    }
    
    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
    
    public void setCopyFoodAnt(Food componentPrevious) {
        this.copyFoodAnt = componentPrevious;
    }

    public Food getFood() {
        return food;
    }
}
