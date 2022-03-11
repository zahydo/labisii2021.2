package co.unicauca.travelagency.server.domain.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.unicauca.Restaurant.commons.domain.Food;
import co.unicauca.Restaurant.commons.domain.FoodTypeEnum;
import co.unicauca.restaurant.server.access.Factory;
import co.unicauca.restaurant.server.access.IFoodRepository;
import co.unicauca.restaurant.server.domain.services.FoodService;

class FoodServiceTest {

	@Test
	void testCreate() {
        System.out.println("create");
        Food food = new Food(10, "Frijoles de prueba", FoodTypeEnum.ENTRADA);
        IFoodRepository repo = Factory.getInstance().getRepository();
        FoodService instance = new FoodService(repo);
        String expectedResult = "10";
        String result = instance.create(food);
        assertEquals(expectedResult, result);

        // Validar un dato erroneo
        food.setName("");
        result = instance.create(food);
        assertTrue(result.contains("BAD_REQUEST"));
	}

	@Test
	void testFindFood() {
        System.out.println("findByIdl");
        int id = 1;
        IFoodRepository repo = Factory.getInstance().getRepository();
        FoodService instance = new FoodService(repo);
        Food result = instance.findFood(id);
        int expectedResult = 1;
        assertEquals(expectedResult, result.getId());

        // Food que no existe
        result = instance.findFood(10);
        assertEquals(null, result);
	}
}
