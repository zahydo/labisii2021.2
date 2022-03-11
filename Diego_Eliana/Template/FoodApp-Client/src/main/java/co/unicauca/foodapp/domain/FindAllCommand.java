package co.unicauca.foodapp.domain;

import co.unicauca.foodapp.commons.domain.Food;
import co.unicauca.foodapp.client.access.Factory;
import co.unicauca.foodapp.client.access.IFoodAccess;
import co.unicauca.foodapp.client.domain.services.FoodService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Comando concreto para buscar todas las comidas
 *
 * @author Diego Collazos, Eliana Cerquera
 */
public class FindAllCommand extends Command {

    /**
     * Lista de comidas
     */
    private List<Food> foods;

    /**
     * Instancia del receptor
     */
    private FoodService service;

    /**
     * Constructor por defecto
     */
    public FindAllCommand() {
        foods = new ArrayList<>();
        IFoodAccess impl = Factory.getInstance().getFoodService();
        service = new FoodService(impl);
        this.hasUndo = false;
    }

    @Override
    public void execute() {
        try {
            Logger logger = LoggerFactory.getLogger(FindAllCommand.class);
            logger.info("Comando de buscar todas las comidas ejecutado.");
            foods = service.findAll();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FindAllCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Getter del listado de comidas
     * @return
     */
    public List<Food> getFoods() {
        return foods;
    }
}
