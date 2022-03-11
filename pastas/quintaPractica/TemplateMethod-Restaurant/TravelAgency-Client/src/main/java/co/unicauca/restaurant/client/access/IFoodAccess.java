package co.unicauca.restaurant.client.access;

import co.unicauca.Restaurant.commons.domain.Food;

/**
 * Interface que define los servicios de persistencia de Clientes de la agencia
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public interface IFoodAccess {

    /**
     * Buscar un cliente utilizando un socket
     *
     * @param id cedula del cliente
     * @return objeto cliente
     * @throws Exception error al buscar un cliente
     */
    public Food findFood(String id) throws Exception;

    /**
     * Crea un Food
     *
     * @param customer cliente de la agencia de viajes
     * @return devuelve la cedula del cliente creado
     * @throws Exception error crear el cliente
     */

    public String createFood(Food customer) throws Exception;
}
