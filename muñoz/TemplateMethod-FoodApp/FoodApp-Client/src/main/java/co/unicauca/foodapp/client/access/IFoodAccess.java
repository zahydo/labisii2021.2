package co.unicauca.foodapp.client.access;

import co.unicauca.foodapp.commons.domain.Food;
import java.util.List;


/**
 * Interface que define los servicios de persistencia de Clientes de la agencia
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public interface IFoodAccess {

    /**
     * Busca una comida 
     * @param id id de la comida a consultar 
     * @return Food 
     * @throws Exception
     */
    public Food findFood(String id) throws Exception;

    /**
     * Solicita la creación de una comida una comida 
     * @param food comida a crear 
     * @return String mensaje de éxito o fallo
     * @throws Exception
     */
    public String createFood(Food food) throws Exception;

    /**
     * Elimina una comida por sus id 
     * @param id id de la comida 
     * @return String mensaja de acierto o de fallo 
     * @throws Exception
     */
    public String delete(int id) throws Exception;

    /**
     * Actualiza una comida 
     * @param food comida a actualizar 
     * @return String mensaje de acierto o de fallo 
     * @throws Exception
     */
    public String update(Food food) throws Exception;

    /**
     * Retorna todas las comidas disponibles
     * @return List<Food> 
     * @throws Exception
     */
    public List<Food> findAll() throws Exception;
}
