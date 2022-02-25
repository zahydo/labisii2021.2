package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.infra.Utilities;

public class CryptFood extends Food {
  private Food myDecoratedFood;

  public CryptFood(int id, String name, FoodTypeEnum type) {
    String encryptedFoodName = Utilities.encode(name);
    myDecoratedFood = new Food(id, encryptedFoodName, type);
  }

  @Override
  public void setName(String name) {
    myDecoratedFood.setName(name);
  }

  @Override
  public String getName() {
    return myDecoratedFood.getName();
  }

  public String decodeName() {
    return Utilities.decode(myDecoratedFood.getName());
  }

  @Override
  public int getId() {
    return myDecoratedFood.getId();
  }

  @Override
  public void setId(int id) {
    myDecoratedFood.setId(id);
  }

  @Override
  public FoodTypeEnum getType() {
    return myDecoratedFood.getType();
  }

  @Override
  public void setType(FoodTypeEnum type) {
    myDecoratedFood.setType(type);
  }

  @Override
  public String toString() {
    return "Food{" + "id=" + myDecoratedFood.getId() + ", name=" + myDecoratedFood.getName() + ", type="
        + myDecoratedFood.getType() + '}';
  }
}
