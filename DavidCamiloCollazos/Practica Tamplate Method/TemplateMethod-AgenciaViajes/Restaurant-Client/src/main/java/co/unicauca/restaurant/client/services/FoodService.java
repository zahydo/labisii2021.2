package co.unicauca.restaurant.client.services;

import co.unicauca.restaurant.client.access.IFoodAccess;
import co.unicauca.restaurant.commons.domain.Food;

/**
 * Es una fachada para comunicar la presentación con el
 * dominio
 *
 * @author David E
 */
public class FoodService {

    private final IFoodAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     * @param service implementacion de tipo ICustomerService
     */
    public FoodService(IFoodAccess service) {
        this.service = service;
    }

    
    /**
     * Crea una comida en el servidor remoto
     * 
     * @param food Comida
     * @return El nombre de la comida creada
     * @throws Exception 
     */
    
    public String createFood(Food food) throws Exception {
        return service.createFood(food);
    }

    
    /**
     * Busca una comida en el servidor remoto
     *
     * @param id identificador de la comida
     * @return Objeto tipo Food, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Food findFood(String id) throws Exception{
        return service.findFood(id);
    }

}
