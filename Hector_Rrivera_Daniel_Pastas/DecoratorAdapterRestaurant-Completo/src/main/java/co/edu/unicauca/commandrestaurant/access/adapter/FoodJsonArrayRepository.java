package co.edu.unicauca.commandrestaurant.access.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.decorator.CryptFood;
import co.edu.unicauca.commandrestaurant.infra.Utilities;

public class FoodJsonArrayRepository {
    private static List<String> foods;
    private static Gson gson = new Gson();

    public FoodJsonArrayRepository() {
        if (foods == null) {

            foods = new ArrayList<>();
            initData();
        }
    }

    /**
     * Adding Key and Value pairs to Hashtable: hashtable.put("Key1","Chaitanya")
     */
    private void initData() {
    	Food f1 = new CryptFood(1, "Frijoles", FoodTypeEnum.PRINCIPIO);
    	Food f2 = new CryptFood(2, "Sopa de Verduras", FoodTypeEnum.ENTRADA);
    	Food f3 = new CryptFood(3, "Jugo de mango", FoodTypeEnum.JUGO);

    	String str = gson.toJson(f1);
    	foods.add(str);
    	str = gson.toJson(f2);
    	foods.add(str);
    	str = gson.toJson(f3);
    	foods.add(str);


    	//foods.add("{\"id\":\"1\",\"name\":\"Frijoles\",\"FoodTypeEnum:\":\"PRINCIPIO\"}");
    	//foods.add("{\"id\":\"2\",\"name\":\"Sopa de Verduras\",\"FoodTypeEnum:\":\"ENTRADA\"}");
    	//foods.add("{\"id\":\"3\",\"name\":\"Jugo de mango\",\"FoodTypeEnum:\":\"JUGO\"}");

    }
    /**
     * Consulta una comida por su id
     * @param id identificador de la comida
     * @return comida
     */
    public Food getById(int id) {
    	Gson g = new Gson();
        CryptFood cf = null;
        for(String aux : foods){
        	System.out.println(aux);
            cf = g.fromJson(aux, CryptFood.class);
            if (cf.getId() == id){

                return new Food(cf.getId(), Utilities.decrypt(cf.getName()),cf.getType());
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
    	CryptFood newFood = new CryptFood(food.getId(), food.getName(), food.getType());
    	if (getById(food.getId()) == null) {
        	String str = gson.toJson(newFood);
        	System.out.println(str);
            foods.add(str);
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
        Food aux = getById(food.getId());
        if (aux != null) {
        	System.out.println("Trying to modify");
        	String str = gson.toJson(food);
            foods.remove(food.getId());
            foods.add(str);
            return true;
        }
        return false;
    }
    /**
     * Elimina una comida
     * @param id identificador de la comida
     */
    public void remove(int id) {
    	 Iterator it = foods.iterator();
    	while (it.hasNext()) {
            Food element = gson.fromJson((String)it.next(), CryptFood.class);
            if (element.getId() == id){
                it.remove();
            }
        }
    }

    /**
     * Devuelve todos las comidas
     * @return platos en en un Mapa
     */
    public List<String> getAll() {
        return foods;
    }


}
