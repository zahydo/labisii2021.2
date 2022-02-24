package co.edu.unicauca.commandrestaurant.access.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.decorator.CapitalFood;
import co.edu.unicauca.commandrestaurant.domain.decorator.CryptFood;

public class FoodRepositoryJsonArrayAdapter implements IFoodRepository {
	/**
     * Repositorio adaptado
     */
    FoodJsonArrayRepository adaptedRepository;

    /**
     * Constructor
     */
    public FoodRepositoryJsonArrayAdapter() {
        adaptedRepository = new FoodJsonArrayRepository();
    }

    @Override
    public Food findById(int id) {
        return adaptedRepository.getById(id);
    }

    @Override
    public List<Food> findAll() {
        List<String> foodlist = adaptedRepository.getAll();
        Gson gson = new Gson();
        List<Food> list = new ArrayList<Food>();
        for (String string : foodlist) {
        	System.out.println(string);
			CryptFood aux = gson.fromJson(string, CryptFood.class);
			list.add(aux);
		}
        
        return list;
    }

    @Override
    public boolean create(Food food) {
    	System.out.println("Utilizando Json Array Adapter");
        return adaptedRepository.add(food);
    }

    @Override
    public boolean update(Food food) {
    	System.out.println("Utilizando Json Array Adapter");
        return adaptedRepository.modify(food);
    }

    @Override
    public void delete(int id) {
    	System.out.println("Utilizando Json Array Adapter");
        adaptedRepository.remove(id);
    }
}
