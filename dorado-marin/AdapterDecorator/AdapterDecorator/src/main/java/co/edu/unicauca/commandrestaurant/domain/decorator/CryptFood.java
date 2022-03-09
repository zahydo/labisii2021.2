package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.unicauca.commandRestaurant.infra.Utilities;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase decorador criptográfico de comida
 *
 * @author Fabián David Marín y Héctor Fernando Dorado
 */
public class CryptFood extends Food{
    private Food myFoodCrypt;
    
    public CryptFood(int id, String name, FoodTypeEnum type){
        try {
            String nombreEncriptado=Utilities.encriptar(name);
            myFoodCrypt=new Food(id, nombreEncriptado, type);
        } catch (Exception ex) {
            Logger.getLogger(CryptFood.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void setId(int id) {
        myFoodCrypt.setId(id);
    }

    @Override
    public int getId() {
        return myFoodCrypt.getId();
    }
    
    
    @Override
    public void setName(String name) {
        myFoodCrypt.setName(name);
    }

    @Override
    public String getName() {
        return myFoodCrypt.getName();
    }

    @Override
    public void setType(FoodTypeEnum type) {
        myFoodCrypt.setType(type);
    }

    @Override
    public FoodTypeEnum getType() {
        return myFoodCrypt.getType();
    }
    @Override
    public String toString() {
        return "Food{" + "id=" + myFoodCrypt.getId() + ", name=" + myFoodCrypt.getName() + ", type=" + myFoodCrypt.getType() + '}';
    }
}
