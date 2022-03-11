package co.unicauca.foodapp.server.access;

import co.unicauca.foodapp.commons.domain.Food;
import java.util.List;

/**
 * Interface que define los servicios de persistencia de comidas
 *
 * @author Diego Collazos, Eliana Cerquera
 */
public interface IFoodRepository {

    /**
     * Busca una comida utilizando un socket
     * @param id de comida a buscar
     * @return Food correspondiente
     */
    public Food findById(int id);

    /**
     * Retorna un listado de las comidas disponibles
     * @return lista de comidas
     */
    public List<Food> findAll();

    /**
     * Crea una comida
     * @param food nueva a crear
     * @return resultado de la operacion
     */
    public boolean create(Food food);

    /**
     * Modifica una comida
     * @param food a ser modificada
     * @return resultado de la operacion
     */
    public boolean update(Food food);

    /**
     * Elimina una comida
     * @param id de la comida a eliminar
     * @return resultado de la operacion
     */
    public boolean delete(int id);
}
