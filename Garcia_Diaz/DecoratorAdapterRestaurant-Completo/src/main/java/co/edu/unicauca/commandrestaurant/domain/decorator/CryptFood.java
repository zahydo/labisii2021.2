
package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.infra.Utilities;

/**
 *
 * @author @author Libardo Pantoja, Julio A. Hurtado
 */
public class CryptFood extends Food implements Decorator {

    private Food myCFood;

    public CryptFood(int id, String name, FoodTypeEnum type) {
        String Cryptname = Utilities.encriptar(name);
        myCFood = new Food(id, Cryptname, type);
        
    }

    @Override
    public void setName(String name) {
        myCFood.setName(Utilities.encriptar(name));

    }

    @Override
    public String getName() {
        return myCFood.getName();
    }

    /**
     *
     * @return Id del plato
     */
    @Override
    public int getId() {
        return myCFood.getId();
    }

    @Override
    public void setId(int id) {
        myCFood.setId(id);
    }

    @Override
    public FoodTypeEnum getType() {
        return myCFood.getType();
    }

    @Override
    public void setType(FoodTypeEnum type) {
        myCFood.setType(type);
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + myCFood.getId() + ", name=" + myCFood.getName() + ", type=" + myCFood.getType() + '}';
    }

}
