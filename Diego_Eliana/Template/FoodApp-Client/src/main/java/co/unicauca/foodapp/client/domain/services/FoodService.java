package co.unicauca.foodapp.client.domain.services;

import co.unicauca.foodapp.commons.domain.Food;
import co.unicauca.foodapp.client.access.IFoodAccess;
import java.util.List;

/**
 * Fachada de los servicios de Food. Es el receptor, al cual se le ejecutan
 * sus operaciones mediante comandos
 *
 * @author Diego Collazos, Eliana Cerquera
 */
public class FoodService {

    /**
     * Dependencia abstracta al repositorio
     */
    private IFoodAccess impl;

    /**
     * Constructor parametrizado
     * @param impl instancia del repositorio
     */
    public FoodService(IFoodAccess impl) {
        this.impl = impl;
    }

    /**
     * Envia la instruccion para crear un Food
     * @param food a ser creado
     * @return resultado de la operacion
     * @throws Exception
     */
    public String create(Food food) throws Exception {
        return impl.create(food);
    }

    /**
     * Envia la instruccion para actualizar un Food
     * @param food a ser actualizado
     * @throws Exception
     */
    public void update(Food food) throws Exception {
        impl.update(food);
    }

    /**
     * Envia la instruccion para eliminar un Food
     * @param id del Food a ser eliminado
     * @throws Exception
     */
    public void delete(int id) throws Exception {
        impl.delete(id);
    }

    /**
     * Envia la instruccion para listar las Food disponibles
     * @return List<Food> de los Food disponibles
     * @throws Exception
     */
    public List<Food> findAll() throws Exception {
        return impl.findAll();
    }

    /**
     * Envia la instruccion para encontrar un Food por su id
     * @param id de la Food a ser encontrada
     * @return Resultado de la operacion
     * @throws Exception
     */
    public Food findByIdl(int id) throws Exception {
        return impl.find(String.valueOf(id));
    }
}
