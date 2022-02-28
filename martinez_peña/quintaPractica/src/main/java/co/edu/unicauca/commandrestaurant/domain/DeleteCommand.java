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
 * @author 57322
 */
public class DeleteCommand extends Command {

    /**
     * Comida a crear
     */
    private Food food;
    /**
     * Instancia al receptor
     */
    private FoodService service;

    public DeleteCommand(Food food) {
        this.food = food;
        IFoodRepository repo = RepositoryFactory.getInstance().getRepository("default");
        service = new FoodService(repo);
        this.hasUndo = true;
    }

    @Override
    public void execute() {
        Logger logger = LoggerFactory.getLogger(CreateCommand.class);
        logger.info("Comando de eliminación ejecutado. Se eliminó la comida " + food.toString());
        service.delete(food.getId());
    }

    @Override
    public void undo() {
        Logger logger = LoggerFactory.getLogger(CreateCommand.class);
        logger.info("Comando de eliminación deshecho. Se agregó la comida " + food.toString());
        System.out.println("Producto" + this.food.toString());
        service.create(food);
    }

}
