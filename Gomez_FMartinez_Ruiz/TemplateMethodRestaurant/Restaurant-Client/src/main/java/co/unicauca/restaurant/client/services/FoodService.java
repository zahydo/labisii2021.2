
package co.unicauca.restaurant.client.services;

import co.unicauca.restaurant.client.access.IFoodAccess;
import co.unicauca.restaurant.commons.domain.Food;

/**
 * Clase de comunicación entre la presentación y el dominio.
 * @author XssIsor
 */
public class FoodService {
    
    private final IFoodAccess service;

    /**
     * Contructor.
     * @param service IFoodAccess. servicio a instanciar.
     */
    public FoodService(IFoodAccess service) {
        this.service = service;
    }


    /**
     * Crea una comida en el server.
     * @param food Food. Comida a crear.
     * @return Id de la comida creada.
     * @throws Exception en caso de que halla un error en la creación o la conexión con el server.
     */
    public String create(Food food) throws Exception {
        return service.createFood(food);
    }

    /**
     * Busca una comida en el server.
     * @param id String. Identificador de la comida
     * @return comida Food
     * @throws Exception si hay un error en la búsqueda o la conexión con el server. 
     */
    public Food findFood(String id) throws Exception{
        return service.findFood(id);
    }
}
