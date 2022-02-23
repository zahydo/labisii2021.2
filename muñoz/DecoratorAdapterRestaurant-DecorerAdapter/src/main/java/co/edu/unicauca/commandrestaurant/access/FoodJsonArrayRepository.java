/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.commandrestaurant.access;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.service.SecurityService;
import com.google.gson.Gson;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés David Muñoz
 */
public class FoodJsonArrayRepository {

    private static ArrayList<String> components;
    private Gson gson;
    private JSONObject objectJson;

    public FoodJsonArrayRepository() throws Exception {
        if (components == null) {
            components = new ArrayList();
            gson = new Gson();
            initData();
        }
    }

    /**
     * Adding Key and Value pairs to Json's Array: list.add(jSon string)
     */
    private void initData() throws Exception {
        components.add(gson.toJson(new Food(1, SecurityService.encode("Frijoles"), FoodTypeEnum.PRINCIPIO)));
        components.add(gson.toJson(new Food(2, SecurityService.encode("Sopa de verduras"), FoodTypeEnum.ENTRADA)));
        components.add(gson.toJson(new Food(3, SecurityService.encode("Jugo de mango"), FoodTypeEnum.JUGO)));

    }

    /**
     * Consulta una comida por su id
     *
     * @param id identificador de la comida
     * @return comida
     */
    public String getById(int id) {
        for (int i = 0; i < components.size(); i++) {
            if (getID(components.get(i)) == id) {
                return components.get(i);
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
    public boolean add(String food) {
        if (getById(getID(food)) == null) {
            components.add(food);
            return true;
        }
        return false;
    }

    /**
     * Modifica una comida
     *
     * @param food comida a modificar
     * @return true si la logra modificar, false en caso contrario
     */
    public boolean modify(String food) {
        int pos = getPosicion(food);
        if (pos != -1) {
            components.set(pos, food);
            return true;
        }
        return false;
    }

    /**
     * Elimina una comida
     *
     * @param id identificador de la comida
     */
    public void remove(int id) {
        String food = getById(id);
        int pos = getPosicion(food);
        if (pos != -1) {
            components.remove(pos);
        }
    }

    /**
     * Devuelve todos las comidas
     *
     * @return platos en en un Mapa
     */
    public ArrayList<String> getAll() {
        return components;
    }

    private int getID(String food) {
        if (food.contains("myDecoratedFood")) {
            objectJson = getMyDecoatedFood(food);
        } else {
            objectJson = new JSONObject(food);
        }
        return objectJson.getInt("id");
    }

    private JSONObject getMyDecoatedFood(String food) {
        objectJson = new JSONObject(food);
        return objectJson.getJSONObject("myDecoratedFood");
    }

    private int getPosicion(String food) {
        if (food == null) {
            return -1;
        }

        int id = getID(food);
        if (id == -1) {
            return -1;
        }
        for (int i = 0; i < components.size(); i++) {
            if (id == getID(components.get(i))) {
                return i;
            }
        }
        return -1;
    }
    
}
