
package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.domain.Food;
import java.util.List;

/**
 *
 * @author Anderson Diaz
 */
public interface IFoodRepository {

    public Food findById(int id);


    public List<Food> findAll();


    public boolean create(Food customer);


    public boolean update(Food customer);


    public boolean delete(int id);
}
