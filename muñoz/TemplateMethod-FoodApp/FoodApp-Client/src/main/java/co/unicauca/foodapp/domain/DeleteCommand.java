/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.foodapp.domain;

import co.unicauca.foodapp.commons.domain.Food;
import co.unicauca.foodapp.client.access.Factory;
import co.unicauca.foodapp.client.access.IFoodAccess;
import co.unicauca.foodapp.client.domain.services.FoodService;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DeleteCommand  elimina una comida 
 * @author Andrés David Muñoz 
 */
public class DeleteCommand extends Command {

    /**
     * id de la comida a eliminar 
     */
    private int foodId;  
    
    
    /**
     * Comida previa, que permitirá deshacer la operación de modificar
     */
    private Food foodPrevious;
    
    /**
     * Instancia al receptor
     */
    private FoodService service;
    
    /**
     * COnstructor parametrizado 
     * 
     * @param food Comida que será eliminada 
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
     * Retorna la comida previa 
     * @return
     */
    public Food getFoodPrevious() {
        return foodPrevious;
    }
    
    /**
     * Actualiza la comida previa 
     * @param food
     */
    public void setFoodPrevious(Food food) {
        this.foodPrevious = food;
    }
    
}
