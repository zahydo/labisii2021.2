package co.unicauca.foodapp.client.domain.services;

import co.unicauca.foodapp.commons.domain.Food;
import co.unicauca.foodapp.client.access.IFoodAccess;
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
    private IFoodAccess impl;

    /**
     * Construcor parametrizado
     *
     * @param ifa
     */
    public FoodService(IFoodAccess impl) {
        this.impl = impl;

    }

    /**
     * Crear una comida
     *
     * @param food comdia a crearse en la bd
     * @return 
     * @throws java.lang.Exception
     */
    public String create(Food food) throws Exception {
        return impl.createFood(food);
    }

    /**
     * Modifica una comida
     *
     * @param food comida a ser grabada en la bd
     * @throws java.lang.Exception
     */
    public void update(Food food) throws Exception {
        impl.update(food);
    }

    /**
     * Eliminar comida
     *
     * @param id identificador de la comida
     * @throws java.lang.Exception
     */
    public void delete(int id) throws Exception {
        impl.delete(id);
    }

    /**
     * Buscar todas las comidas
     *
     * @return lista de comidas
     * @throws java.lang.Exception
     */
    public List<Food> findAll() throws Exception {
        return impl.findAll();
    }

    /**
     * Buscar comida por su id
     *
     * @param id identificador de la comida
     * @return Comida
     * @throws java.lang.Exception
     */
    public Food findByIdl(int id) throws Exception {
        return impl.findFood(String.valueOf(id));
    }

}
