package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.decorator.CapitalFood;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jandresordonez
 */
public class FoodJsonArrayRepository {
    private static List<String> foods;

    public FoodJsonArrayRepository() {
        if (foods == null) {
            foods = new ArrayList<>();
            initData();
        }
    }

    private void initData() {
        Gson g = new Gson();
        foods.add(g.toJson(new CapitalFood(1, "Fríjoles", FoodTypeEnum.PRINCIPIO)));
        foods.add(g.toJson(new CapitalFood(2, "Sopa de verduras", FoodTypeEnum.ENTRADA)));
        foods.add(g.toJson(new CapitalFood(3, "Jugo de mango", FoodTypeEnum.JUGO)));
    }
    /**
     * Consulta una comida por su id
     * @param id identificador de la comida
     * @return comida
     */
    public Food getById(int id) {
        Gson g = new Gson();
        Food element = null;
        for(String aux : foods){
            element = g.fromJson(aux, CapitalFood.class);
            if (element.getId() == id){
                return element;
            }
        }
        return null;
    }
    /**
     * Agrega una comida
     * @param food comida a agregar
     * @return true si la agrega, false en caso contrario
     */
    public boolean add(Food food) {
        Gson g = new Gson();
        
        Food element = null;
        for(String aux : foods){
            element = g.fromJson(aux, CapitalFood.class);
            if (element.getId() == food.getId()){
                return false;
            }
        }
        foods.add(g.toJson(food));
        return true;
    }
    /**
     * Modifica una comida
     * @param food comida a modificar
     * @return true si la logra modificar, false en caso contrario
     */
    public boolean modify(Food food) {
        Gson g = new Gson();
        Iterator itr = foods.iterator();
 
        while (itr.hasNext()) {
            Food element = g.fromJson((String)itr.next(), CapitalFood.class);
            if (element.getId() == food.getId()){
                itr.remove();
                this.add(food);
                return true;
            }
        }
        return false;
    }
    /**
     * Elimina una comida
     * @param id identificador de la comida
     */
    public void remove(int id) {
        Gson g = new Gson();
        Iterator itr = foods.iterator();
 
        while (itr.hasNext()) {
            Food element = g.fromJson((String)itr.next(), CapitalFood.class);
            if (element.getId() == id){
                itr.remove();
            }
        }
    }

    /**
     * Devuelve todos las comidas
     * @return platos en en una lista String
     */
    public List<String> getAll() {
        return foods;
    }

}
