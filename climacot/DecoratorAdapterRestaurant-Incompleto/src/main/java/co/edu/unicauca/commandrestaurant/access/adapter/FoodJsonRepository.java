package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.decorator.CryptFood;
import co.edu.unicauca.commandrestaurant.infra.Utilities;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class FoodJsonRepository {
  private static List<String> components;
  private static Gson gson = new Gson();

  public FoodJsonRepository() {
    if (components == null) {
      components = new ArrayList<>();
      initData();
    }
  }

  /**
   * Adding Key and Value pairs to Hashtable: hashtable.put("Key1","Chaitanya")
   */
  private void initData() {
    components.add(gson.toJson(new CryptFood(1, "Fríjoles", FoodTypeEnum.PRINCIPIO)));
    components.add(gson.toJson(new CryptFood(2, "Sopa do macaco", FoodTypeEnum.PRINCIPIO)));
    components.add(gson.toJson(new CryptFood(3, "Sopa de coco", FoodTypeEnum.PRINCIPIO)));
  }

  /**
   * Consulta una comida por su id
   * 
   * @param id identificador de la comida
   * @return comida
   */
  public Food getById(int id) {
    for (String comp : components) {
      CryptFood food = gson.fromJson(comp, CryptFood.class);

      if (food.getId() == id) {
        food.setName(Utilities.decode(food.getName()));
        return food;
      }
    }
    return null;
  }

  /**
   * Agrega una comida
   * 
   * @param food comida a agregar
   * @return true si la agrega, false en caso contrario
   */
  public boolean add(Food food) {
    Gson gson = new Gson();
    String name = food.getName();
    if (name == null) {
      name = food.getName();
    }
    String foodJson = gson.toJson(new CryptFood(food.getId(), name, food.getType()));
    components.add(foodJson);
    return true;
  }

  /**
   * Modifica una comida
   * 
   * @param food comida a modificar
   * @return true si la logra modificar, false en caso contrario
   */
  public boolean modify(Food food) {
    for (int i = 0; i < components.size(); i++) {
      CryptFood aux = gson.fromJson(components.get(i), CryptFood.class);
      if (aux.getId() == food.getId()) {
        // Modificamos sus datos
        aux.setName(Utilities.encode(food.getName()));
        aux.setType(food.getType());
        String rmp = gson.toJson(aux);
        components.set(i, rmp);
        return true;
      }
    }
    return false;
  }

  /**
   * Elimina una comida
   * 
   * @param id identificador de la comida
   */
  public void remove(int id) {
    Gson gson = new Gson();
    int i = 0;
    for (String componentAux : components) {
      CryptFood food = gson.fromJson(componentAux, CryptFood.class);
      if (food.getId() == id) {
        components.remove(i);
        return;
      }
      i++;
    }
  }

  /**
   * Devuelve todos las comidas
   * 
   * @return platos en en un Mapa
   */
  public List<Food> getAll() {
    List<Food> auxComp = new ArrayList<>();
    for (String componentAux : components) {
      CryptFood auxFood = gson.fromJson(componentAux, CryptFood.class);
      auxComp.add(auxFood);
    }
    return auxComp;
  }
}
