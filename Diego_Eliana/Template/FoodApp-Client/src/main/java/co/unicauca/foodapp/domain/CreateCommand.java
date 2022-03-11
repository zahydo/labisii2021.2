package co.unicauca.foodapp.domain;

import co.unicauca.foodapp.commons.domain.Food;
import co.unicauca.foodapp.client.access.Factory;
import co.unicauca.foodapp.client.access.IFoodAccess;
import co.unicauca.foodapp.client.domain.services.FoodService;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Comando concreto para crear una comida
 *
 * @author Diego Collazos, eliana Cerquera
 */
public class CreateCommand extends Command {

    /**
     * Instancia de comida a crear
     */
    private Food food;

    /**
     * Instancia del receptor
     */
    private FoodService service;

    /**
     * Constructor parametrizado
     * @param food a crear
     */
    public CreateCommand(Food food) {
        this.food = food;
        IFoodAccess impl = Factory.getInstance().getFoodService();
        service = new FoodService(impl);
        this.hasUndo = true;
    }

    @Override
    public void execute() {
        try {
            Logger logger= LoggerFactory.getLogger(CreateCommand.class);
            logger.info("Comando de creación ejecutado. Se creo la comida " + food.toString());
            service.create(food);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CreateCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void undo() {
        try {
            Logger logger= LoggerFactory.getLogger(CreateCommand.class);
            logger.info("Comando de creación deshecho. Se eliminó la comida " + food.toString());
            service.delete(food.getId());
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CreateCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
