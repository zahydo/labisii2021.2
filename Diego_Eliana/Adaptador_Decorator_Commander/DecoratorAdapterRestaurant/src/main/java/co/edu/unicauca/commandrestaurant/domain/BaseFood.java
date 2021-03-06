package co.edu.unicauca.commandrestaurant.domain;

import co.edu.unicauca.commandrestaurant.domain.decorator.Food;

/**
 * Representa una comida del restaurante de cualquier tipo: Entrada, principio,
 * carne, postre
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class BaseFood implements Food {
    
    private int id;
    private String name;
    private FoodTypeEnum type;

    public BaseFood(){}
    public BaseFood(int id, String name, FoodTypeEnum type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public FoodTypeEnum getType() {
        return type;
    }
    public void setType(FoodTypeEnum type) {
        this.type = type;
    }

    // Food interface implementation methods
    public String getName() {
        return name;
    }    
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + id + ", name=" + name + ", type=" + type + '}';
    }
}
