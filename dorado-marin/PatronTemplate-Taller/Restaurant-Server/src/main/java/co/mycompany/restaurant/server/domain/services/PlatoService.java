package co.mycompany.restaurant.server.domain.services;

import co.mycompany.restaurant.commons.infra.JsonError;
import co.mycompany.restaurant.commons.infra.Utilities;
import com.google.gson.Gson;
import co.mycompany.restaurant.commons.domain.Plato;
import java.util.ArrayList;
import java.util.List;
import co.mycompany.restaurant.server.access.IPlatoRepository;

/**
 * @author Fabián David Marín - Hector Fernando Dorado
 * 
 * Clase con los servicios del plato
 */
public class PlatoService {

    IPlatoRepository repo;

    /**
     * Constructor parametrizado
     *
     * @param repo repositorio de tipo IPlatoRepository en el cual se hace la inyección
     */
    public PlatoService(IPlatoRepository repo) {
        this.repo = repo;
    }

    /**
     * Crea un nuevo plato
     *
     * @param plato plato
     * @return devuelve el nombre del plato creado
     */
    public String crerPlato(Plato plato) {
        List<JsonError> errors = new ArrayList<>();
        // Se gestionan las validaciones
        if(!(Utilities.isNumeric(plato.getPlatoId()))){
            errors.add(new JsonError("400", "BAD_REQUEST","Precio incorrecto. Solo se aceptan valores numericos"));
        }
        if (plato.getPlatoNombre().isEmpty() || plato.getPlatoPrecio().isEmpty()
                || plato.getPlatoDescripcion().isEmpty()) {
           errors.add(new JsonError("400", "BAD_REQUEST","Los campos nombre, precio y descripción no pueden quedar vacios"));
        }
        
        if(!(Utilities.isNumeric(plato.getPlatoPrecio()))){
            errors.add(new JsonError("400", "BAD_REQUEST","Precio incorrecto. Solo se aceptan valores numericos"));
        }
       // gestion de los errores en caso de que suceda alguno de ellos en los anteriores pasos
       if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }             
        return repo.crearPlato(plato);
    }
}
