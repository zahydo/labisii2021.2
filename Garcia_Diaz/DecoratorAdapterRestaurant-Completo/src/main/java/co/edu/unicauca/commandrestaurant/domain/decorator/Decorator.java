
package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;

/**
 *
 * @author @author Libardo Pantoja, Julio A. Hurtado
 */
public interface Decorator {

    int getId();

    String getName();

    FoodTypeEnum getType();

    void setId(int id);

    void setName(String name);

    void setType(FoodTypeEnum type);

    @Override
    String toString();
    
}
