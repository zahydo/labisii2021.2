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

/**
 *
 * @author Kevin Daryany Morales Cruz
 */
public class DeleteByIdCommand extends Command {
    /**
     * Comida previa, que permitirá deshacer la operación de eliminar
     */
    private Food foodPrevious;
    /**
     * id de la comida a buscar
     */
    private int foodId;
    /**
     * Instancia al receptor
     */
    private FoodService service;

    public DeleteByIdCommand(int foodId) {
        this.foodId= foodId;
        IFoodRepository repo = RepositoryFactory.getInstance().getRepository("default");
        service = new FoodService(repo);
        this.hasUndo = true;
    }

    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(DeleteByIdCommand.class); 
        logger.info("Comando de eliminar comida por id se ha ejecutado. Id " + foodId);          
         service.delete(foodId);
    }

    public Food getFoodPrevious() {
        return foodPrevious;
    }

    public void setFoodPrevious(Food foodPrevious) {
        this.foodPrevious = foodPrevious;
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(UpdateCommand.class); 
        logger.info("Comando de eliminar se ha deshecho. Se grabó la comida " + foodPrevious);             
        service.create(foodPrevious);
    }

}
