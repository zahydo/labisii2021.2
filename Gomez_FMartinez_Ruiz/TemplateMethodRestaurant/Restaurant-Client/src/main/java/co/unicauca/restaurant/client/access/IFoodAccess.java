package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.commons.domain.Food;

/**
 *
 * @author XssIsor
 */
public interface IFoodAccess {
    
    /**
     * Crea una nueva comida.
     * @param food Food. Comida a agregar
     * @return String. id de la comida agregada.
     * @throws Exception . Si se presenta un problema al crear la comida
     */
    public String createFood(Food food) throws Exception;

    /**
     * Busca una comida por su id.
     * @param id String. Identificador de la comida.
     * @return Food. La comida que se busca.
     * @throws Exception . Si se presenta un problema al buscar la comida
     */
    public Food findFood(String id) throws Exception;
}
