package co.unicauca.Restaurante.server.domain.services;

import co.unicauca.Restaurante.commons.domain.Food;
import co.unicauca.Restaurante.commons.infra.JsonError;
import co.unicauca.Restaurante.commons.infra.Utilities;
import co.unicauca.Restaurante.server.access.IFoodRepository;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de clientes. Da acceso a la lógica de negocio
 *
 * @author Libardo, Julio
 */
/**
 * Fachada de los servicios de comida. Es el receptor, al cual se le ejecutan
 * sus operaciones mediante comandos
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class FoodService {
    /**
     * Dependencia abstracta al repositorio
     */
    private IFoodRepository repo;

    /**
     * Construcor parametrizado
     *
     * @param repo repositorio que es inyectado
     */
    public FoodService(IFoodRepository repo) {
        this.repo = repo;

    }

    /**
     * Crear una comida
     *
     * @param food comdia a crearse en la bd
     */
    public String create(Food food) {
        List<JsonError> errors = new ArrayList<>();

        // Validaciones y reglas de negocio
        if (food.getId() < 0 || food.getName().isEmpty()) {
          errors.add(new JsonError("400", "BAD_REQUEST", "El id debe ser mayor a cero, el nombre no puede ser vacio"));
        }

        // Que no esté repetido

        Food FoodSearched = this.findFood(food.getId());
        if (FoodSearched != null) {
          errors.add(new JsonError("400", "BAD_REQUEST", "La id ya existe. "));
        }

        if (!errors.isEmpty()) {
          Gson gson = new Gson();
          String errorsJson = gson.toJson(errors);
          return errorsJson;
        }

        return repo.create(food);
      }
    
    public Food findFood(int id){
        return repo.findById(id);
    }
}

