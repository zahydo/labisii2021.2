/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.decorator.CryptFood;
import java.util.ArrayList;
import java.util.List;

/**
 * repositorio que permite grabar y recuperar comidas en un arreglo String Json
 *
 * 
 */
public class FoodJsonArrayRepository implements IFoodJsonRepository {

    private static List<Food> foods;

    public FoodJsonArrayRepository() {
        if (foods == null) {
            foods = new ArrayList<>();
            initData();
        }
    }

    private void initData() {
        foods.add(new CryptFood(0, "Arroz", FoodTypeEnum.ENTRADA));
        foods.add(new CryptFood(1, "jugo de mango", FoodTypeEnum.JUGO));
    }

    @Override
    public List<String> foods() {
        List<String> listAux = new ArrayList<>();
        for (Food dato : foods) {
            listAux.add(dato.getId() + "," + dato.getName() + "," + dato.getType());
        }
        return listAux;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Food getById(int id) {
        for (Food dato : foods) {
            if (dato.getId() == id) {
                return dato;
            }
        }
        return null;
    }

    /**
     *
     * @param food
     * @return
     */
    @Override
    public boolean add(Food food) {
        for (Food dato : foods) {
            if (dato.equals(food)) {
                return false;
            }
        }
        foods.add(food);
        return true;
    }

    /**
     *
     * @param id
     */
    @Override
    public void remove(int id) {
        for (Food dato : foods) {
            if (dato.getId() == id) {
                foods.remove(dato);
                break;
            }
        }
    }

    /**
     *
     * @param food
     * @return
     */
    @Override
    public boolean modify(Food food) {
        for (Food dato : foods) {
            if (dato.getId() == food.getId()) {
                foods.remove(dato);
                foods.add(food);
                return true;
            }
        }
        return false;
    }

}
