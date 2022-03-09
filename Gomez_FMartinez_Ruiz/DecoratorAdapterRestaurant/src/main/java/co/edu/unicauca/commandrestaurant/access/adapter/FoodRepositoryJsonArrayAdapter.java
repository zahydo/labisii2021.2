/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.access.FoodJsonArrayRepository;
import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.decorator.CryptFood;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XssIsor
 */
public class FoodRepositoryJsonArrayAdapter implements IFoodRepository{

    FoodJsonArrayRepository jsonAdaptedRepository;

    public FoodRepositoryJsonArrayAdapter(){
        jsonAdaptedRepository = new FoodJsonArrayRepository();
    }

    /**
     * Obtiene una comida por id
     * @param id de la comida
     * @return La comida
     */
    @Override
    public Food findById(int id) {
        return jsonAdaptedRepository.getFoodById(id);
    }

    
    /**
     * Envia una lista con las comidas encriptadas.
     * @return Una lista con la comida encriptada.
     */
    @Override
    public List<Food> findAll() {
        List<String> foodlist = jsonAdaptedRepository.getAllFoods();
        Gson gson = new Gson();
        List<Food> list = new ArrayList<Food>();
        for (String food : foodlist) {
            System.out.println(food);
            CryptFood aux = gson.fromJson(food, CryptFood.class);
            list.add(aux);
        }
        return list;
    }
    
    /**
     * Crea una nueva comida.
     * @param food la comida a agregar.
     * @return true si lo hace con éxito, false si no.
     */
    @Override
    public boolean create(Food food) {
        return jsonAdaptedRepository.add(food);
    }

    /**
     * Actualiza una comida existente.
     * @param food la comida a actualizar
     * @return true si lo hace con éxito, false si no.
     */
    @Override
    public boolean update(Food food) {
        return jsonAdaptedRepository.modify(food);
    }

    /**
     * Elimina una comida por id.
     * @param id de la comida que se va a eliminar
     */
    @Override
    public void delete(int id) {
        jsonAdaptedRepository.remove(id);
    }


}
