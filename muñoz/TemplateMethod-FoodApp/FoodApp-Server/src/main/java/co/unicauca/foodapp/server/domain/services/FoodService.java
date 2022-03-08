package co.unicauca.foodapp.server.domain.services;

import co.unicauca.foodapp.commons.domain.Food;
import co.unicauca.foodapp.server.access.IFoodRepository;
import co.unicauca.foodapp.commons.infra.JsonError;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;


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
     * @param ifr
     */
    public FoodService(IFoodRepository repo) {
        this.repo = repo;

    }

    /**
     * Crear una comida
     *
     * @param food comdia a crearse en la bd
     * @return 
     */
    public synchronized String create(Food food) {
        List<JsonError> errors = new ArrayList<>();

        // Validaciones y reglas de negocio
        if (food == null || food.getName().isEmpty() || food.getId() <= 0 || food.getType() == null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "código comida, nombre, type son obligatorios."));
        }

        if (findByIdl(food.getId()) != null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "Ya existe una comida con ese Ientidicafor. "));
        }

        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }

        if (repo.create(food)) {
            return "Guardado con éxito" + food.toString();
        }
        return "Error: algo salió mal..consultar con el administrador del sistema";
    }

    /**
     * Modifica una comida
     *
     * @param food comida a ser grabada en la bd
     * @return 
     */
    public synchronized String update(Food food) {
        List<JsonError> errors = new ArrayList<>();

        // Validaciones y reglas de negocio
        if (food == null || food.getName().isEmpty() || food.getId() <= 0 || food.getType() == null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "código comida, nombre, type son obligatorios."));
        }

        if (findByIdl(food.getId()) == null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "No existe una comida con ese Ientidicafor. "));
        }

        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }

        if (repo.update(food)) {
            return "Actualizado con éxito" + food.toString();
        }
        return "Error: algo salió mal..consultar con el administrador del sistema";
    }

    /**
     * Eliminar comida
     *
     * @param id identificador de la comida
     * @return 
     */
    public synchronized String delete(int id) {
        List<JsonError> errors = new ArrayList<>();

        // Validaciones y reglas de negocio
        if (id < 0) {
            errors.add(new JsonError("400", "BAD_REQUEST", "codigo de entidad obligatorio."));
        }
        Food food = findByIdl(id); 
        if (food == null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "No existe una entidad con ese código."));
        }

        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }

        if (repo.delete(id)){
            return "Eliminado con éxito elemento " + String.valueOf(id);
        }
        return "Error: algo salió mal..consultar con el administrador del sistema";
    }

    /**
     * Buscar todas las comidas
     *
     * @return lista de comidas
     */
    public synchronized List<Food> findAll() {
        return repo.findAll();
    }

    /**
     * Buscar comida por su id
     *
     * @param id identificador de la comida
     * @return Comida
     */
    public synchronized Food findByIdl(int id) {
        return repo.findById(id);
    }

}
