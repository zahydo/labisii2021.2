package co.unicauca.restaurant.server.access;
import java.util.ArrayList;
import java.util.List;

import co.unicauca.Restaurant.commons.domain.Food;
import co.unicauca.Restaurant.commons.domain.FoodTypeEnum;

/**
 * Implementación del repositorio con arreglos
 *
 * @author Libardo, Julio
 */
public class FoodImplArrayRepository implements IFoodRepository {

    private static List<Food> components;

    /**
     * Constructor de FoodImplArrayRepository
     */
    public FoodImplArrayRepository() {
        if (components == null) {
            components = new ArrayList<>();
            initData();
        }
    }

    /**
     * Datos que se inicializan al iniciar crear la instancia.
     * Se podria decir que son dafault.
     */
    private void initData() {
        components.add(new Food(1, "Fríjoles", FoodTypeEnum.PRINCIPIO));
        components.add(new Food(2, "Sopa de verduras", FoodTypeEnum.ENTRADA));
        components.add(new Food(3, "Jugo de mango", FoodTypeEnum.JUGO));

    }

    /**
     * Busca una comida por el ID
     * @param id id de la comida
     * @return devuelve null si no encuentra la comida, si la encuentra devuelve un objeto tipo Food
     */
    @Override
    public Food findById(int id) {
        for (Food comp : components) {
            if (comp.getId() == id) {
                return comp;
            }
        }
        return null;
    }

    /**
     * Crea una comida
     * @param component la comida
     * @return el id de la comida
     */
    @Override
    public String create(Food component) {
        components.add(component);
        return String.valueOf(component.getId());
    }

}