package co.edu.unicauca.commandrestaurant.access.adapter;

import java.util.List;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.infra.Utilities;

public class FoodRepositoryJsonAdapter implements IFoodRepository {

  FoodJsonRepository foodJsonRepository;

  public FoodRepositoryJsonAdapter() {
    foodJsonRepository = new FoodJsonRepository();
  }

  @Override
  public Food findById(int id) {
    return foodJsonRepository.getById(id);
  }

  @Override
  public List<Food> findAll() {
    return foodJsonRepository.getAll();
  }

  @Override
  public boolean create(Food food) {
    return foodJsonRepository.add(food);
  }

  @Override
  public boolean update(Food food) {
    return foodJsonRepository.modify(food);
  }

  @Override
  public void delete(int id) {
    foodJsonRepository.remove(id);
  }
}
