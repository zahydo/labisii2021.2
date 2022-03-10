package co.unicauca.foodapp.client.access;

import co.unicauca.foodapp.commons.domain.Food;
import java.util.List;

/**
 * Servicio de Food. Permite hacer el CRUD de foods solicitando los
 * servicios con la aplicación server. Maneja los errores devueltos
 *
 * @author Diego Collazos, Eliana Cerquera
 */
public interface IFoodAccess {

    /**
     * Encuentra un Food por su id
     * @param id de la comida a buscar
     * @return Food correspondiente a esa id, o null si no la encuentra
     * @throws Exception
     */
    public Food find(String id) throws Exception;

    /**
     * Solicita la creación de una comida 
     * @param food objeto Food con la informacion del nuevo Food a crear 
     * @return String resultado de la operacion
     * @throws Exception
     */
    public String create(Food food) throws Exception;

    /**
     * Solicita el borrado de una comida 
     * @param id de la comida a borrar 
     * @return String resultado de la operacion
     * @throws Exception
     */
    public String delete(int id) throws Exception;

    /**
     * Actualiza una comida
     * @param food comida a actualizar 
     * @return String resultado de la operacion
     * @throws Exception
     */
    public String update(Food food) throws Exception;

    /**
     * Solicita el listado de Food's en el servidor
     * @return List<Food> con las Food disponibles en el servidor
     * @throws Exception
     */
    public List<Food> findAll() throws Exception;
}