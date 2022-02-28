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
 * @author XssIsor
 */
public class DeleteUndoCommand extends Command {
    
    
    /*
    Instancia del servicio de comida
    */
    private FoodService service;
    /*
    Instancia de comida a manipular
    */
    private Food food;
    

    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(UpdateCommand.class); 
        logger.info("Se ha ejecutado el comando de eliminación. Comida Eliminada: " + food);            
        service.delete(food.getId());
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(UpdateCommand.class); 
        logger.info("Se ha ejecutado el comando de restauración. Comida Restaurada: " + food);             
        service.create(food);
    }
    
     public DeleteUndoCommand(Food food) {
        this.food = food;
        IFoodRepository repo = RepositoryFactory.getInstance().getRepository("default");
        service = new FoodService(repo);
        this.hasUndo = true;
    }
}
