/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.commandrestaurant.domain;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.access.RepositoryFactory;
import co.edu.unicauca.commandrestaurant.domain.service.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Jose Ricardo
 */
public class DeleteByIdCommand extends Command{

    private int foodId;
    private Food foodPrevious;
    private FoodService service;

    public DeleteByIdCommand(int id) {
        IFoodRepository repo = RepositoryFactory.getInstance().getRepository("default");
        this.foodId =id;
        service = new FoodService(repo);
        this.hasUndo = true;             
    }
    

    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(DeleteByIdCommand.class); 
        logger.info("Comando de eliminar comida por id se ha ejecutado. Id " + foodId);            
        service.delete(foodId);
  
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(DeleteByIdCommand.class); 
        logger.info("Comando de eliminacion se ha deshecho. Se grabó la comida " + foodPrevious);             
        service.create(foodPrevious);
    }
    
    public Food getFoodPrevious() {
        return foodPrevious;
    }

    public void setFoodPrevious(Food componentPrevious) {
        this.foodPrevious = componentPrevious;
    }
    
}
