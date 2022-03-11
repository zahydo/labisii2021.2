
package co.unicauca.restaurant.server.domain.services;

import co.unicauca.restaurant.server.access.IRepository;
import co.unicauca.travelagency.commons.domain.Food;
import co.unicauca.travelagency.commons.infra.JsonError;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 57322
 */
public class FoodService {

    /**
     * Repositorio del restaurante
     */
    IRepository repo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio del restaurante, tipo IRepository
     */
    public FoodService(IRepository repo) {
        this.repo = repo;
    }

    /**
     * Obtiene un plato por su Id
     *
     * @param id identificación del plato
     * @return Food, plato ubicado o nulo en caso contrario
     */
    public Food obtenerPlato(String id) {
        /*Validaciones de Negocio*/
        if (id.isEmpty()) {
            return null;
        }
        return repo.obtenerPlato(id);
    }

    /**
     * Crea un plato en el repositorio correspondiente
     *
     * @param food
     * @return Respuesta en formato Json
     */
    public String crearPlato(Food food) {
        List<JsonError> errors = new ArrayList<>(); //Aquí se guardan los errores detectados
        if (food.getId().isEmpty() || food.getNameFood().isEmpty() || food.getPrecio() == 0) {
            errors.add(new JsonError("400", "BAD_REQUEST", "id,nombre, precio: Son campos obligatorios"));
        }
        //Que no existe
        if (this.obtenerPlato(food.getId()) != null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "Esta comida ya existe "));
        }
        //Si hubo algún error
        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }
        //Si no hay errores de negocio
        return repo.crearPlato(food);
    }

}
