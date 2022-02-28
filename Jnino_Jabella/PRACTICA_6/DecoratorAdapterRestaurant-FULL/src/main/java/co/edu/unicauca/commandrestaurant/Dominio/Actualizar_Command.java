package co.edu.unicauca.commandrestaurant.Dominio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Comando concreto para modificar una comida
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class Actualizar_Command extends Command_Comida {

    /**
     * Comida a ser modificada
     */
    private Comida food;
    /**
     * Comida previa, que permitirá deshacer la operación de modificar
     */
    private Comida foodPrevious;
    /**
     * Constructor parametrizado
     * @param food comida a modificar
     */
    public Actualizar_Command(Comida food) {
        this.food = food;
        this.hasUndo = true;
    }

    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(Actualizar_Command.class); 
        logger.info("Comando de edición se ha ejecutado. Se grabó la comida " + food);            
        service.update(food);
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(Actualizar_Command.class); 
        logger.info("Comando de edición se ha deshecho. Se grabó la comida " + foodPrevious);             
        service.update(foodPrevious);
    }

    public Comida getFoodPrevious() {
        return foodPrevious;
    }

    public void setFoodPrevious(Comida componentPrevious) {
        this.foodPrevious = componentPrevious;
    }

}
