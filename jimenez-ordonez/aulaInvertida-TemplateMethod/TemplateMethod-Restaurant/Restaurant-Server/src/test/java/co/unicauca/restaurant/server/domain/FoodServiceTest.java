package co.unicauca.restaurant.server.domain;

import co.unicauca.restaurant.server.domain.services.FoodService;
import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.server.access.FoodFactory;
import co.unicauca.restaurant.server.access.IFoodRepository;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Libardo, Julio
 */
public class FoodServiceTest {
    
    @Test
    public void testFindFood() {
        System.out.println("findFoood");
        String id = "1";
        IFoodRepository repo = FoodFactory.getInstance().getRepository();
        FoodService instance = new FoodService(repo);
        String expResult = "1";
        Food result = instance.findFood(id);
        assertEquals(expResult, result.getId());
        
        // Customer que no existe
        result = instance.findFood("12345678");
        assertEquals(null, result);

    }
    
    @Test
    public void testCreateFood() {
        Food food = new Food();
        food.setId("10");
        food.setName("Frijoles con garra");
        food.setDescription("Incluye tajada");
        
        IFoodRepository repo = FoodFactory.getInstance().getRepository();
        FoodService instance = new FoodService(repo);
        String expResult = "10";
        String result = instance.createFood(food);
        assertEquals(expResult, result);
        
        // Validar un dato erroneo
        food.setName("");
        result = instance.createFood(food);
        assertTrue(result.contains("BAD_REQUEST"));
                    
    }
    
}

