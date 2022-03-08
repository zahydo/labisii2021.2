package co.unicauca.travelagency.client.access;

import co.unicauca.travelagency.commons.domain.Food;

/**
 * Interface que define los servicios de persistencia de Clientes de la agencia
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public interface IFoodAccess {
    /**
     * Crea una Food
     *
     * @param food comida del restaurante
     * @return devuelve el id del plato
     * @throws Exception error crear la comida
     */
    public String createFood(Food food) throws Exception;

    /**
     * Busca una Food por su id
     * 
     * @param id id de la comida
     * @return devuelve la comida
     * @throws Exception Error al buscar la comida
     */
    public Food findFood(String id) throws Exception;
}
