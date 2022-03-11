package co.unicauca.foodapp.domain;

import co.unicauca.foodapp.commons.domain.Food;
import co.unicauca.foodapp.client.access.Factory;
import co.unicauca.foodapp.client.access.IFoodAccess;
import co.unicauca.foodapp.client.domain.services.FoodService;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Comando concreto para buscar una comida por su id
 *
 * @author Diego Collazos, Eliana Cerquera
 */
public class FindByIdCommand extends Command {

    /**
     * Instancia de la comida encontrada
     */
    private Food food;

    /**
     * Id de la comida a buscar
     */
    private int foodId;

    /**
     * Instancia al receptor
     */
    private FoodService service;

    /**
     * Constructor por defecto
     */
    public FindByIdCommand() {
        IFoodAccess impl = Factory.getInstance().getFoodService();
        service = new FoodService(impl);
        this.hasUndo = false;
    }

    @Override
    public void execute() {
        try {
            Logger logger= LoggerFactory.getLogger(FindByIdCommand.class);
            logger.info("Comando de buscar buscar comida por id se ha ejecutado. Id " + foodId);
            food = service.findByIdl(foodId);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FindByIdCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Getter de foodId
     * @return
     */
    public int getFoodId() {
        return foodId;
    }

    /**
     * Setter de FoodId
     * @param foodId
     */
    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    /**
     * Getter de la comida encontrada
     * @return
     */
    public Food getFood() {
        return food;
    }
}
