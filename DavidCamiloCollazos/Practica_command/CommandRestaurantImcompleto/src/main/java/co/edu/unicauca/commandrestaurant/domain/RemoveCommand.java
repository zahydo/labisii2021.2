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
 * @author David E
 */
public class RemoveCommand extends Command{

    private int id;
    private FoodService service;
    
    /**
     * Comida previa, que permitirá deshacer la operación de modificar
     */
    private Food foodPrevious;
    
    public RemoveCommand(int id){
        this.id = id;
        IFoodRepository repo = RepositoryFactory.getInstance().getRepository("default");
        service = new FoodService(repo);
        this.hasUndo = true;
    }
    
    
    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(RemoveCommand.class); 
        logger.info("Comando de borrar una comida." );            
        service.delete(id);
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(RemoveCommand.class); 
        logger.info("Comando de eliminacion deshecho. Se guardo la comida " + foodPrevious.getName());        
        service.create(foodPrevious);
    }
    
    public void setFoodPrevious(Food componentPrevious) {
        this.foodPrevious = componentPrevious;
    }
    
}
