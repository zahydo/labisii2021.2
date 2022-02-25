package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.decorator.CryptFood;
import co.edu.unicauca.commandrestaurant.infra.Utilities;
import java.util.Map;
import java.util.HashMap;

/**
 * Implementación del repositorio con Mapas
 *
 * @author
 */
public class FoodCryptRepository {

    private static Map<Integer, Food> components;

    public FoodCryptRepository() {
        if (components == null) {
            components = new HashMap<>();
            initData();
        }
    }

    /**
     * Adding Key and Value pairs to Hashtable: hashtable.put("Key1","Chaitanya")
     */
    private void initData() {
        components.put(1, new CryptFood(1, "Fríjoles", FoodTypeEnum.PRINCIPIO));
        components.put(2, new CryptFood(2, "Sopa de verduras", FoodTypeEnum.ENTRADA));
        components.put(3, new CryptFood(3, "Jugo de mango", FoodTypeEnum.JUGO));

    }
    /**
     * Consulta una comida por su id
     * @param id identificador de la comida
     * @return comida
     */
    public Food getById(int id) {
        Food element = components.get(id);
        if (element == null){
            return null;
        }
        return new Food(element.getId(), Utilities.decode(element.getName()), element.getType());
    }
    /**
     * Agrega una comida
     * @param food comida a agregar
     * @return true si la agrega, false en caso contrario
     */
    public boolean add(Food food) {
        CryptFood element = new CryptFood(food.getId(),food.getName(),food.getType());
        if (components.get(element.getId()) == null) {
            components.put(element.getId(), element);
            return true;
        }
        return false;
    }
    /**
     * Modifica una comida
     * @param food comida a modificar
     * @return true si la logra modificar, false en caso contrario
     */
    public boolean modify(Food food) {
        Food aux = components.get(food.getId());
        
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
    public Map<Integer, Food> getAll() {
        return components;
    }

}
