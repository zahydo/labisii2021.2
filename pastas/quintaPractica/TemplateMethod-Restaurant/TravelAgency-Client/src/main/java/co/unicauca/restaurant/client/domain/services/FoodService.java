package co.unicauca.restaurant.client.domain.services;

import co.unicauca.Restaurant.commons.domain.Food;
import co.unicauca.restaurant.client.access.IFoodAccess;

/**
 * Es una fachada para comunicar la presentación con el
 * dominio
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public class FoodService {

    private final IFoodAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     * @param service implementacion de tipo IFoodService
     */
    public FoodService(IFoodAccess service) {
        this.service = service;
    }

    /**
     * Busca un cliente en el servidor remoto
     *
     * @param id identificador del cliente
     * @return Objeto tipo Cliente, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Food findFood(String id) throws Exception {
        return service.findFood(id);

    }
    
    public String createFood(Food customer) throws Exception {
        return service.createFood(customer);

    }    

}
