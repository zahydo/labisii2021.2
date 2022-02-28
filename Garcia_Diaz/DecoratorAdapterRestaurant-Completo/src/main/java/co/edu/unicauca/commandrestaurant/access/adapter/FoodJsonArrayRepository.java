
package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.domain.Food;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author @author Libardo Pantoja, Julio A. Hurtado
 */
public class FoodJsonArrayRepository {
    private static ArrayList<String> components;
    private final Gson gson;
    
    public FoodJsonArrayRepository() {
        this.gson = new Gson();
        if (components == null) {
            components = new ArrayList<>();
        } 
    }
   
    /**
     * Consulta una comida por su id
     * @param id identificador de la comida
     * @return comida
     */
    public Food getById(int id) {
        for(String token:components){
            if (token.contains("\"id\":"+id)){
                return gson.fromJson(token, Food.class);
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
        if (this.getById(food.getId()) == null) {
            components.add(gson.toJson(food));
            return true;
        }
        return false;
    }
    /**
     * Modifica una comida
     * @param food comida a modificar
     * @return true si la logra modificar, false en caso contrario
     */
    public boolean modify(Food food) {
        Food aux = this.getById(food.getId());
        if (aux != null) {
            this.remove(aux.getId());
            this.add(food);
            return true;
        }
        return false;
    }
    /**
     * Elimina una comida
     * @param id identificador de la comida
     * @return 
     */
    public boolean remove(int id) {
         for(String token:components){
            if (token.contains("\"id\":"+id)){
                components.remove(token);
                return true;                        
            }
        }           
        return false;
    }

    /**
     * Devuelve todos las comidas
     * @return platos en en un Mapa
     */
    public ArrayList<String> getAll() {
        return components;
    }
}
