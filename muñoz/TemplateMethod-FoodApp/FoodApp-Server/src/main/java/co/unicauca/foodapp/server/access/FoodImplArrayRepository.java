package co.unicauca.foodapp.server.access;


import co.unicauca.foodapp.commons.domain.Food;
import co.unicauca.foodapp.commons.domain.FoodTypeEnum;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del repositorio con arreglos
 *
 * @author Libardo, Julio
 */
public class FoodImplArrayRepository implements IFoodRepository {

    private static List<Food> components;

    /**
     * Constructor por defecto 
     */
    public FoodImplArrayRepository() {
        if (components == null) {
            components = new ArrayList<>();
            initData();
        }
    }

    /**
     * Inicializar los datos del array 
     */
    private void initData() {
        components.add(new Food(1, "Fríjoles", FoodTypeEnum.PRINCIPIO));
        components.add(new Food(2, "Sopa de verduras", FoodTypeEnum.ENTRADA));
        components.add(new Food(3, "Jugo de mango", FoodTypeEnum.JUGO));

    }

    @Override
    public Food findById(int id) {
        for (Food comp : components) {
            if (comp.getId() == id) {
                return comp;
            }
        }
        return null;
    }

    @Override
    public boolean create(Food component) {
        components.add(component);
        return true;
    }

    @Override
    public boolean update(Food component) {
        for (Food componentAux : components) {
            if (componentAux.getId() == component.getId()) {
                //Modificamos sus datos
                componentAux.setName(component.getName());
                componentAux.setType(component.getType());
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean delete(int id) {
        int i = 0;
        for (Food componentAux : components) {
            if (componentAux.getId() == id) {
                components.remove(i);
                return true;
            }
            i++;
        }
        return false;  
    }

    /**
     * Busca los registros de las comidas existentes 
     *
     * @return lista de comidas 
     */
    @Override
    public List<Food> findAll() {
        return components;
    }

}
