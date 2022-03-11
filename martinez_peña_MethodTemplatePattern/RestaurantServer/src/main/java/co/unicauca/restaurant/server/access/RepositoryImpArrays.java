/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.access;

import co.unicauca.travelagency.commons.domain.Food;
import java.util.ArrayList;

/**
 * Interface del respositorio de platos
 *
 * @author Julián Martinez, Paula Peña
 */
public class RepositoryImpArrays implements IRepository {

    /**
     * Se inicializa el repositorio
     */
    private ArrayList<Food> foods;

    /**
     * Constructor
     */
    public RepositoryImpArrays() {
        if (foods == null) {
            this.foods = new ArrayList<>();//Asignación de memoria del respositorio
        }
        if (foods.size() == 0) {
            initFoods();
        }

    }

    /**
     * Obtiene un plato del repositorio de lista
     *
     * @param id
     * @return
     */
    @Override
    public Food obtenerPlato(String id) {
        for (Food f : this.foods) {
            if (f.getId().equals(id)) {
                return f;
            }
        }
        return null;
    }

    /**
     * Agrega un plato al repositorio de arreglos
     *
     * @param food
     * @return
     */
    @Override
    public String crearPlato(Food food) {
        this.foods.add(food);
        return food.getId();
    }

    private void initFoods() {
        foods.add(new Food("1", "Hamburguesa", 18000, 0));
        foods.add(new Food("2", "Pechuga Gratinada", 15000, 1 / 10));
        foods.add(new Food("3", "Pizza", 16000, 2 / 10));
        foods.add(new Food("4", "Aborrajado", 12000, 0));
        foods.add(new Food("5", "Estofado", 13000, 0));
        foods.add(new Food("6", "Carne a la parrilla", 17000, 0));
        foods.add(new Food("7", "Perro Caliente", 10000, 0));
    }

}
