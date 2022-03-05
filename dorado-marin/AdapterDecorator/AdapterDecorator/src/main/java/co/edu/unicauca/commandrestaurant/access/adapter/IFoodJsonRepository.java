package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.domain.Food;
import java.util.List;

/**
 * @author Fabián David Marín y Héctor Fernando Dorado
 */

public interface IFoodJsonRepository {
    public boolean add(Food food);
    public void remove(int id);
    public boolean modify(Food food);
    public Food getById(int id);
    public List<String> foods();
}
