package co.edu.unicauca.commandrestaurant.Acceso.Adapter;

import co.edu.unicauca.commandrestaurant.Dominio.Comida;
import java.util.Map;
import java.util.HashMap;

/**
 * Implementación del repositorio con Mapas
 *
 * @author @author Libardo Pantoja, Julio A. Hurtado
 */
public class FoodMapRepository {

    private static Map<Integer, Comida> components;

    public FoodMapRepository() {
        if (components == null) {
            components = new HashMap<>();
            //initData();
        }
    }

    /**
     * Adding Key and Value pairs to Hashtable: hashtable.put("Key1","Chaitanya")
     */

    /**
     * Consulta una comida por su id
     * @param id identificador de la comida
     * @return comida
     */
    public Comida getById(int id) {
        return components.get(id);
    }
    /**
     * Agrega una comida
     * @param food comida a agregar
     * @return true si la agrega, false en caso contrario
     */
    public boolean add(Comida food) {
        if (components.get(food.getId()) == null) {
            components.put(food.getId(), food);
            return true;
        }
        return false;
    }
    /**
     * Modifica una comida
     * @param food comida a modificar
     * @return true si la logra modificar, false en caso contrario
     */
    public boolean modify(Comida food) {
        Comida aux = components.get(food.getId());
        if (aux != null) {
            this.remove(aux.getId());
            this.add(food);
            return true;
        }
        return false;
    }
    /**
     * Elimina una comida
     * @param id identificador de la comida
     */
    public void remove(int id) {
        components.remove(id);
    }

    /**
     * Devuelve todos las comidas
     * @return platos en en un Mapa
     */
    public Map<Integer, Comida> getAll() {
        return components;
    }

}
