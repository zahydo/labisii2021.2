/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.commandrestaurant.domain;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.access.RepositoryFactory;
import co.edu.unicauca.commandrestaurant.domain.service.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    
    public DeleteCommand(Food food) {
        this.foodPrevious = food;
        IFoodRepository repo = RepositoryFactory.getInstance().getRepository("default");
        service = new FoodService(repo);
        this.foodId = this.foodPrevious.getId();  
        this.hasUndo = true;
    }

    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(DeleteCommand.class); 
        logger.info("Comando de eliminación ejecutado. Se borró la comida " + this.getFoodPrevious().toString());
        service.delete(foodId);
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(DeleteCommand.class); 
        logger.info("Comando de eliminación deshecho. Se restauró la comida " + this.getFoodPrevious().toString());        
        service.create(this.getFoodPrevious());
    }
    
    public Food getFoodPrevious() {
        return foodPrevious;
    }
    
    public void setFoodPrevious(Food food) {
        this.foodPrevious = food;
    }
    
}
