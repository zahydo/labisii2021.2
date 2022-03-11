package co.unicauca.restaurant.server.domain.services;

import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.commons.infra.JsonError;
import co.unicauca.restaurant.server.access.IFoodRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Libardo, Julio
 */
public class FoodService {
    
    /**
     * Repositorio de comidas
     */
    IFoodRepository repo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo IFoodRepository
     */
    public FoodService(IFoodRepository repo) {
        this.repo = repo;
    }

    /**
     * Buscar una comida
     *
     * @param id id
     * @return objeto tipo Food
     */
    public Food findFood(String id) {
        return repo.findFood(id);
    }

    /**
     * Crea un nuevo customer. Aplica validaciones de negocio
     *
     * @param Food food
     * @return devuelve el id de la comida creada
     */
    public String createFood(Food food) {
        List<JsonError> errors = new ArrayList<>();
  
              
        // Validaciones y reglas de negocio
        if (food.getId().isEmpty() || food.getName().isEmpty() || food.getDescription().isEmpty()) {
           errors.add(new JsonError("400", "BAD_REQUEST","id, nombre y despripcion son campos obligatorios. "));
        }

        // Que no esté repetido        
        Food foodSearched = this.findFood(food.getId());
        if (foodSearched != null){
            errors.add(new JsonError("400", "BAD_REQUEST","El id ya existe. "));
        }
        
        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }             
        
        return repo.createFood(food);
    }


}
