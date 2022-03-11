
package co.unicauca.travelagency.server.domain;

import co.unicauca.travelagency.server.domain.services.FoodService;
import co.unicauca.travelagency.commons.domain.Food;
import co.unicauca.travelagency.commons.domain.FoodTypeEnum;
import co.unicauca.travelagency.server.access.Factory;
import co.unicauca.travelagency.server.access.IFoodRepository;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Libardo, Julio
 */
public class FoodServiceTest {

    /**
     * Test of create method, of class FoodService.
     */
    @Test
    public void testCreate() {

        System.out.println("create");
        Food food = new Food(10, "Frijoles de prueba", FoodTypeEnum.ENTRADA);
        IFoodRepository repo = Factory.getInstance().getRepository();
        FoodService instance = new FoodService(repo);
        String expResult = "10";
        String result = instance.create(food);
        assertEquals(expResult, result);

        // Validar un dato erroneo
        food.setName("");
        result = instance.create(food);
        assertTrue(result.contains("BAD_REQUEST"));
    }

    /**
     * Test of findByIdl method, of class FoodService.
     */
    @Test
    public void testFindByIdl() {

        System.out.println("find by id");
        int id = 1;
        IFoodRepository repo = Factory.getInstance().getRepository();
        FoodService instance = new FoodService(repo);
        Food result = instance.findByIdl(id);
        int expResult = 1;
        assertEquals(expResult, result.getId());

        // Food que no existe
        result = instance.findByIdl(100);
        assertEquals(null, result);
    }

}