package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.commons.domain.Food;

/**
 * Interface que define los servicios de persistencia de Clientes de la agencia
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public interface IFoodAccess {

    /**
     * Buscar un plato usando un socket
     *
     * @param id id del plato
     * @return objeto Food
     * @throws Exception error al buscar un cliente
     */
    public Food findFood(String id) throws Exception;


    /**
     * Crea un Customer
     *
     * @param food plato del restaurante
     * @return devuelve el id del plato creado
     * @throws Exception error crear Food
     */
    public String createFood(Food food) throws Exception;
    
}
