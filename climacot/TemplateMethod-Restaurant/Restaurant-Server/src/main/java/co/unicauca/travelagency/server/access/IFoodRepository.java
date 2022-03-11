package co.unicauca.travelagency.server.access;

import co.unicauca.travelagency.commons.domain.Food;

public interface IFoodRepository {

  /**
   * Crea un Plato
   *
   * @param food plato
   * @return el id de la comida
   */
  public String create(Food food);

  /**
   * Buscar un plato utilizando su id.
   *
   * @param id id del plato
   * @return objeto Food
   */
  public Food findById(int id);
}
