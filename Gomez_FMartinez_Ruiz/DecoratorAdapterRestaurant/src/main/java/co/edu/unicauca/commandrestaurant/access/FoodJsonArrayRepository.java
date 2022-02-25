/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.commandrestaurant.access;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.decorator.CryptFood;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XssIsor
 */
public class FoodJsonArrayRepository {
    private static Gson gson = new Gson();
    private static List<String> foods;
  

    public FoodJsonArrayRepository() {
        if (foods == null) {
            foods = new ArrayList<String>();
            initData();
        }
    }
    
    /**
     * Inicializa los datos con los que trabajará.
     */
    private void initData() {
    	Food food1 = new CryptFood(1, "Ribaye", FoodTypeEnum.CARNE);
    	Food food2 = new CryptFood(2, "Limonada", FoodTypeEnum.JUGO);
    	Food food3 = new CryptFood(3, "Flan", FoodTypeEnum.POSTRE);

    	String reponse = gson.toJson(food1);
    	foods.add(reponse);
    	reponse = gson.toJson(food2);
    	foods.add(reponse);
    	reponse = gson.toJson(food3);
    	foods.add(reponse);
    }
    
     /**
     * Agrega una nueva comida.
     * @param food comida a agregar.
     * @return true si se agrega con exito, false si no.
     */
    public boolean add(Food food) {

        if (getFoodById(food.getId()) == null) {
        	String reponse = gson.toJson(food);
            foods.add(reponse);
            return true;
        }
        return false;
    }
    
    /**
     * Remueve una comida por id.
     * @param id de la comida a remover.
     */
    public void remove(int id) {
    	String reponse = gson.toJson(getFoodById(id)); 
        foods.remove(reponse);
    }
    
    /**
     * Modifica o reempalza una comida existente.
     * @param food comida a modificar o reemplazar.
     * @return true si se modifica o reemplaza correctamente, false si no.
     */
    public boolean modify(Food food) {
        Food foodAux = getFoodById(food.getId());
        if (foodAux != null) {
        String reponse = gson.toJson(food);
            foods.remove(food.getId());
            foods.add(reponse);
            return true;
        }
        return false;
    }


    /**
     * Getter de todas las comidas de la lista.
     * @return Lista de comidas.
     */
    public List<String> getAllFoods() {
        return foods;
    }
    
      /**
     * Obtiene una comida por id.
     * @param id de la comida.
     * @return Food.
     */
    public Food getFoodById(int id) {
    	Gson gson = new Gson();
        Food food;
        for(String aux : foods){
            food = gson.fromJson(aux, CryptFood.class);
            if (food.getId() == id){
                return food;
            }
        }
        return null;
    }
    
    
}
