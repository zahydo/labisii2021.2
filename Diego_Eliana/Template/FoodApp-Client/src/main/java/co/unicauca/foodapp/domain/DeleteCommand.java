package co.unicauca.foodapp.domain;

import co.unicauca.foodapp.commons.domain.Food;
import co.unicauca.foodapp.client.access.Factory;
import co.unicauca.foodapp.client.access.IFoodAccess;
import co.unicauca.foodapp.client.domain.services.FoodService;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Comando concreto para eliminar una comida
 * @author Diego Collazos, Eliana Cerquera
 */
public class DeleteCommand extends Command {

    /**
     * Id de la comida a eliminar
     */
    private int foodId;

    /**
     * Comida que se elimina, permite deshacer el comando y recuperar la comida
     */
    private Food foodPrevious;

    /**
     * Instancia al receptor
     */
    private FoodService service;
    
    /**
     * Constructor parametrizado
     * @param food
     */
    public DeleteCommand(Food food) {
        this.foodPrevious = food;
        IFoodAccess impl = Factory.getInstance().getFoodService();
        service = new FoodService(impl);
        this.foodId = this.foodPrevious.getId();  
        this.hasUndo = true;
    }

    @Override
    public void execute() {
        try {
            Logger logger= LoggerFactory.getLogger(DeleteCommand.class);
            logger.info("Comando de eliminación ejecutado. Se borró la comida " + this.getFoodPrevious().toString());
            service.delete(foodId);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(DeleteCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void undo() {
        try {
            Logger logger= LoggerFactory.getLogger(DeleteCommand.class);
            logger.info("Comando de eliminación deshecho. Se restauró la comida " + this.getFoodPrevious().toString());
            service.create(this.getFoodPrevious());
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(DeleteCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Getter de foodPrevious
     * @return
     */
    public Food getFoodPrevious() {
        return foodPrevious;
    }
    
    /**
     * Setter de foodPrevious
     * @param food que se elimino
     */
    public void setFoodPrevious(Food food) {
        this.foodPrevious = food;
    }
}
