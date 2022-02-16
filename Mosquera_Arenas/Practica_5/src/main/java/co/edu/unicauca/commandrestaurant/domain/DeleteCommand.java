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
 * @author Sebastian_Arenas
 */
public class DeleteCommand extends Command{

    private int idFood;
    
    private Food deletedFood;
    
    private boolean state = false;
    
    /**
     * Instancia al receptor
     */
    private FoodService service;
    
    /**
     * Constructor
     */
    public DeleteCommand() {
        IFoodRepository repo = RepositoryFactory.getInstance().getRepository("default");
        service = new FoodService(repo);
        //No tiene deshacer
        this.hasUndo = true;
    }
    
    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(FindByIdCommand.class); 
        logger.info("Comando de eliminar comida por id se ha ejecutado. Id " + idFood);
        this.state = service.delete(idFood);
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(UpdateCommand.class); 
        logger.info("Comando de eliminacion se ha deshecho. Se instauro la comida" + deletedFood);
        service.create(deletedFood);
    }

    public int getIdFood() {
        return idFood;
    }

    public Food getDeletedFood() {
        return deletedFood;
    }

    public void setDeletedFood(Food deletedFood) {
        this.deletedFood = deletedFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    
    
    
}
