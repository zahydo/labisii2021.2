
package co.unicauca.restaurant.server.domain.services;

import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.server.access.IFoodRepository;
import java.util.List;

/**
 *
 * @author Anderson Diaz
 */
public class FoodService {

    private IFoodRepository repo;


    public FoodService(IFoodRepository repo) {
        this.repo = repo;

    }


    public boolean create(Food food) {
        return repo.create(food);
    }


    public void update(Food food) {
        repo.update(food);
    }


    public boolean delete(int id) {
        return repo.delete(id);
    }


    public List<Food> findAll() {
        return repo.findAll();
    }

 
    public Food findByIdl(int id) {
        return repo.findById(id);
    }
}
