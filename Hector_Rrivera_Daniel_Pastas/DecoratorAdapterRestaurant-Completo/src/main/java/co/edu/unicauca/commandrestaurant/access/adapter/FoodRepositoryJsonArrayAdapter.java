package co.edu.unicauca.commandrestaurant.access.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.decorator.CapitalFood;
import co.edu.unicauca.commandrestaurant.domain.decorator.CryptFood;
import co.edu.unicauca.commandrestaurant.infra.Utilities;

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
    	Food f = adaptedRepository.getById(id);
    	
    	//f.setName(Utilities.decrypt(f.getName()));
    	
        return f;
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
    	
        return adaptedRepository.add(food);
    }

    @Override
    public boolean update(Food food) {
    	
        return adaptedRepository.modify(food);
    }

    @Override
    public void delete(int id) {
    	
        adaptedRepository.remove(id);
    }
}
