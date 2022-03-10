package co.unicauca.foodapp.domain;

import co.unicauca.foodapp.commons.domain.Food;
import co.unicauca.foodapp.client.access.Factory;
import co.unicauca.foodapp.client.access.IFoodAccess;
import co.unicauca.foodapp.client.domain.services.FoodService;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Comando concreto para modificar una comida
 *
 * @author Diego Collazos, Eliana Cerquera
 */
public class UpdateCommand extends Command {

    /**
     * Instancia de comida a ser modificada
     */
    private Food food;

    /**
     * Instancia de la comida antes de modificarse
     */
    private Food foodPrevious;

    /**
     * Instancia del receptor
     */
    private FoodService service;

    /**
     * Constructor parametrizado
     * @param food nueva a modificar
     */
    public UpdateCommand(Food food) {
        this.food = food;
        IFoodAccess impl = Factory.getInstance().getFoodService();
        service = new FoodService(impl);
        this.hasUndo = true;
    }

    @Override
    public void execute() {
        try {
            Logger logger= LoggerFactory.getLogger(UpdateCommand.class);
            logger.info("Comando de edición se ha ejecutado. Se grabó la comida " + food);
            service.update(food);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(UpdateCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void undo() {
        try {
            Logger logger= LoggerFactory.getLogger(UpdateCommand.class);
            logger.info("Comando de edición se ha deshecho. Se grabó la comida " + foodPrevious);
            service.update(foodPrevious);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(UpdateCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Getter de foodPrevious
     * @return comida antes de modificarse
     */
    public Food getFoodPrevious() {
        return foodPrevious;
    }

    /**
     * Setter de foodPrevious
     * @param componentPrevious comida antes de ser modificada
     */
    public void setFoodPrevious(Food componentPrevious) {
        this.foodPrevious = componentPrevious;
    }
}
