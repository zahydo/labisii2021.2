package co.edu.unicauca.commandrestaurant.domain;
import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.access.RepositoryFactory;
import co.edu.unicauca.commandrestaurant.domain.service.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteCommand extends Command{

   
    private Food food;
    private Food foodPrevious;
    private int foodId;
    private FoodService service;

    public DeleteCommand(Food food) {
        this.food = food;
        IFoodRepository repositorio = RepositoryFactory.getInstance().getRepository("default");
        service = new FoodService(repositorio);
        this.hasUndo = true;
    }
    
    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(DeleteCommand.class); 
        logger.info("Comando de eliminación ejecutado. Se eliminó la comida:  " + food.toString());          
        service.delete(foodId);
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(DeleteCommand.class); 
        logger.info("Comando de eliminación deshecho. Se restableció la comida " + food.toString());        
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
