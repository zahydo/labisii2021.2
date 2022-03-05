package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import java.util.ArrayList;
import java.util.List;


public class FoodRepositoryJsonArrayAdapter implements IFoodRepository {
    /**
     * Repositorio adaptado
     */
    private FoodJsonArrayRepository service;
    
    /**
     * Constructor
     */
    public FoodRepositoryJsonArrayAdapter(){
        service=new FoodJsonArrayRepository();
    }
    @Override
    public Food findById(int id) {
        return service.getById(id);
    }

    @Override
    public List<Food> findAll() {
        List<Food> foods=new ArrayList<>();
        String [] da=null;
        for (String fd : service.foods()) {
            da=fd.split(",");
            foods.add(new Food(Integer.parseInt(da[0]), da[1], FoodTypeEnum.valueOf(da[2])));
        }
        return foods;
    }

    @Override
    public boolean create(Food food) {
        return service.add(food);
    }

    @Override
    public boolean update(Food food) {
        return service.modify(food);
    }

    @Override
    public void delete(int id) {
        service.remove(id);
    }
}
