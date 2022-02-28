/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.domain.Food;
import java.util.List;

/**
 *
 * @author David E
 */
public class FoodRepositoryJsonArrayAdapter implements IFoodRepository{
    
    
    FoodJsonArrayRepository adaptedRepository;
    
    public FoodRepositoryJsonArrayAdapter() {
        adaptedRepository = new FoodJsonArrayRepository();
    }
    
    @Override
    public Food findById(int id) {
        return adaptedRepository.findById(id);
    }

    @Override
    public List<Food> findAll() {
        return adaptedRepository.findAll();
    }

    @Override
    public boolean create(Food food) {
        return adaptedRepository.create(food);
    }

    @Override
    public boolean update(Food food) {
        return adaptedRepository.update(food);
    }

    @Override
    public void delete(int id) {
        adaptedRepository.delete(id);
    }
    
}
