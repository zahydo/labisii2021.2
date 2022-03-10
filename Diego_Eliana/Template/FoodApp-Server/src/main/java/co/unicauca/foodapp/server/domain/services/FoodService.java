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
 * @author Diego Collazos, Eliana Cerquera
 */
public class FoodService {

    /**
     * Dependencia abstracta al repositorio
     */
    private IFoodRepository repo;

    /**
     * Constructor parametrizado
     * @param repo instancia de IFoodRepository
     */
    public FoodService(IFoodRepository repo) {
        this.repo = repo;
    }

    /**
     * Crear una comida
     * @param food a crear
     * @return String con el resultado de la operacion
     */
    public synchronized String create(Food food) {
        List<JsonError> errors = new ArrayList<>();

        if (food == null || food.getName().isEmpty() || food.getId() <= 0 || food.getType() == null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "código comida, nombre, type son obligatorios."));
        }

        if (findById(food.getId()) != null) {
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
     * @param food a modificar
     * @return String con el resultado de la operacion
     */
    public synchronized String update(Food food) {
        List<JsonError> errors = new ArrayList<>();

        if (food == null || food.getName().isEmpty() || food.getId() <= 0 || food.getType() == null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "código comida, nombre, type son obligatorios."));
        }

        if (findById(food.getId()) == null) {
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
     * Elimina una comida
     * @param id de la comida a ser eliminada
     * @return String con el resultado  de la operacion
     */
    public synchronized String delete(int id) {
        List<JsonError> errors = new ArrayList<>();

        if (id < 0) {
            errors.add(new JsonError("400", "BAD_REQUEST", "codigo de entidad obligatorio."));
        }
        Food food = findById(id); 
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
     * Listar todas las comidas
     * @return lista de comidas
     */
    public synchronized List<Food> findAll() {
        return repo.findAll();
    }

    /**
     * Encuentra una comida por su id
     * @param id de la comida a encontrar
     * @return Food encontrada
     */
    public synchronized Food findById(int id) {
        return repo.findById(id);
    }
}
