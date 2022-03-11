package co.unicauca.foodapp.server.access;

import co.unicauca.foodapp.commons.domain.Food;
import java.util.List;


/**
 * Interface que define los servicios de persistencia de comidas
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public interface IFoodRepository {

    /**
     * Buscar un cliente utilizando un socket
     *
     * @param id cedula del cliente
     * @return objeto cliente
     */
    public Food findById(int id);

    /**
     * Retorna las comidas disponibles 
     *
     * @return lista de clientes
     */
    public List<Food> findAll();

    /**
     * Crea una comida 
     *
     * @param customer cliente de la agencia de viajes
     * @return true si se creo con exito 
     */
    public boolean create(Food customer);

    /**
     * Modifica una comida 
     *
     * @param customer comida a ser odificada 
     * @return true si lo modifica con exito, false en caso contrario
     */
    public boolean update(Food customer);

    /**
     * Eliminar una comida 
     *
     * @param id identificador de la comida a eliminar
     * @return 
     */
    public boolean delete(int id);

}
