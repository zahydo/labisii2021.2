package co.edu.unicauca.commandrestaurant.access.adapter;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.decorator.Food;

public class FoodJsonArrayRepository {
    private static List<String> foods;
    private String template;
    private Gson gson;

    public FoodJsonArrayRepository() {
        if (foods == null) {
            template = "{\"id\": %d," +
                        "\"name\": \"%s\"," + 
                        "\"type\": \"%s\"}";
            foods = new ArrayList<String>();
            gson = new Gson();
            initData();
        }
    }

    /**
     * Agrega valores iniciales a la lista de comidas al formatear los valores en
     * la template
     */
    private void initData() {
        foods.add(String.format(template, 1, "Fríjoles", FoodTypeEnum.PRINCIPIO));
        foods.add(String.format(template, 2, "Sopa de verduras", FoodTypeEnum.ENTRADA));
        foods.add(String.format(template, 3, "Jugo de mango", FoodTypeEnum.JUGO));
    }

    /**
     * Consulta una comida por su id
     * @param obj instrucción json con la key id a buscar
     * @return Food
     * obj must be: 
     * String idBuscar = "{\"id\": 1}";
     * JsonObject gsonObj = JsonParser.parseString(idBuscar)
     */
    public Food getById(JsonObject gsonObj) {
        for (String eachFood : foods) {
            JsonObject jsonFood = JsonParser.parseString(eachFood).getAsJsonObject();
            if (jsonFood.get("id").getAsInt() == gsonObj.get("id").getAsInt()) {
                return gson.fromJson(eachFood, Food.class);
            }
        }
        return null;
    }

    /**
     * Agrega una comida
     * @param obj sentencia Json con los datos de Food a crear
     * @return true si la agrega, false en caso contrario
     * obj must be: 
     * String idBuscar = "{\"id\": 4,\"name\": \"Frijolito\",\"type\": \"Entrada\"}";
     * JsonObject gsonObj = JsonParser.parseString(idBuscar)
     */
    public boolean add(JsonObject gsonObj) {
        int posIns = foods.size()-1;
        for (int i = 0; i < foods.size(); i++) {
            JsonObject jsonFood = JsonParser.parseString(foods.get(i)).getAsJsonObject();
            if (jsonFood.get("id").getAsInt() == gsonObj.get("id").getAsInt())
                return false;
            if (jsonFood.get("id").getAsInt() < gsonObj.get("id").getAsInt())
                posIns = i;
        }
        foods.add(++posIns, gsonObj.toString());
        return true;
    }

    /**
     * Modifica una comida
     * @param obj sentencia Json con los datos a modificar
     * @return true si la logra modificar, false en caso contrario
     */
    public boolean modify(JsonObject gsonObj) {
        for (int i = 0; i < foods.size(); i++) {
            JsonObject jsonFood = JsonParser.parseString(foods.get(i)).getAsJsonObject();
            if (jsonFood.get("id").getAsInt() == gsonObj.get("id").getAsInt()){
                foods.set(i, gsonObj.toString());
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina una comida
     * @param id Sentencia json con la id de comida a eliminar
     * obj must be: 
     * String idBuscar = "{\"id\": 1}";
     * JsonObject gsonObj = JsonParser.parseString(idBuscar)
     */
    public void remove(JsonObject gsonObj) {
        for (int i = 0; i < foods.size(); i++) {
            JsonObject jsonFood = JsonParser.parseString(foods.get(i)).getAsJsonObject();
            if (jsonFood.get("id").getAsInt() == gsonObj.get("id").getAsInt()){
                foods.remove(i);
            }
        }
    }

    public boolean undoDelete(JsonObject gsonObj) {
        JsonObject jsonFood = JsonParser.parseString(gsonObj.get("id").getAsString()).getAsJsonObject();
        if (getById(jsonFood) != null)
            return false;
        if (foods.size() == 0) {
            foods.add(gsonObj.toString());
            return true;
        }
        return add(gsonObj);
    }

    /**
     * Devuelve todos las comidas
     * @return platos en una lista
     */
    public List<String> getAll() {
        return foods;
    }
}
