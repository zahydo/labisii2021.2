package co.edu.unicauca.commandrestaurant.domain;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.access.RepositoryFactory;
import co.edu.unicauca.commandrestaurant.domain.service.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteCommand extends Command {

  /**
   * Comida a ser modificada
   */
  private int idFood;
  /**
   * Comida previa, que permitirá deshacer la operación de eliminar
   */
  private Food foodPrevious;
  /**
   * Instancia del receptor
   */
  private FoodService service;

  public DeleteCommand(int id) {
    this.idFood = id;
    IFoodRepository repo = RepositoryFactory.getInstance().getRepository("default");
    service = new FoodService(repo);
    this.hasUndo = true;
  }

  @Override
  public void execute() {
    Logger logger = LoggerFactory.getLogger(UpdateCommand.class);
    logger.info("Comando de eliminacion se ha ejecutado. Se elimino la comida " + idFood);
    service.delete(idFood);
  }

  @Override
  public void undo() {
    Logger logger = LoggerFactory.getLogger(UpdateCommand.class);
    logger.info("Comando de eliminacion se ha deshecho. Se restauro la comida " + foodPrevious);
    service.create(foodPrevious);
  }

  public Food getFoodPrevious() {
    return foodPrevious;
  }

  public void setFoodPrevious(Food componentPrevious) {
    this.foodPrevious = componentPrevious;
  }
}
