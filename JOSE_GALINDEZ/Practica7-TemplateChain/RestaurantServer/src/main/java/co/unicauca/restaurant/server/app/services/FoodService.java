package co.unicauca.restaurant.server.app.services;

import co.unicauca.restaurant.common.domain.Food;
import co.unicauca.restaurant.common.domain.JsonError;
import co.unicauca.restaurant.server.app.access.IFoodRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class FoodService {

    private IFoodRepository repository;

    public FoodService(IFoodRepository repository) {
        this.repository = repository;

    }

    public String create(Food food) {
        List<JsonError> errors = new ArrayList<>();

        if (food.getId() < 0 || food.getName().isEmpty()) {
            errors.add(new JsonError("400", "BAD_REQUEST", "El id debe ser mayor a cero, el nombre no puede ser vacio"));
        }

        Food FoodSearched = this.findByIdl(food.getId());
        if (FoodSearched != null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "La id ya existe. "));
        }

        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }

        return repository.create(food);
    }

    public Food findByIdl(int id) {
        return repository.findById(id);
    }

}
