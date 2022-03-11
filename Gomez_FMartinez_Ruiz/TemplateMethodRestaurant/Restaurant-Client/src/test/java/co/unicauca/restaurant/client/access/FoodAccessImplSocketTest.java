package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.client.infra.RestaurantSocket;
import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.commons.domain.FoodTypeEnum;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author XssIsor
 */
public class FoodAccessImplSocketTest {
    
    private RestaurantSocket socket;
    
    public FoodAccessImplSocketTest() {
    }

    /**
     * Test del método de entrada de el cliente para encontrar comida por ID.
     */
    @Test
    public void testFindFood() throws Exception {
        
        FoodAccessImplSocket test = new FoodAccessImplSocket();
        Food food = new Food(1, "Fríjoles", FoodTypeEnum.PRINCIPIO);
        Food response = test.findFood("1");
        assertEquals(response.getName(), food.getName());
        food = new Food(2, "Sopa de verduras", FoodTypeEnum.ENTRADA);
        response = test.findFood("2");
        assertEquals(response.getName(), food.getName());
        
        
    }
    
     /**
     * Test del método de entrada de el cliente para encontrar comida por ID.
     * En caso de que se lance una excepción.
     */
    @Test(expected=Exception.class)
    public void testFindFood2() throws Exception {
        FoodAccessImplSocket test = new FoodAccessImplSocket();
        Food response = test.findFood("159");
    }

    /**
     * Test del método de entrada del cliente para crear una comida.
     */
    @Test
    public void testCreateFood() throws Exception {
        FoodAccessImplSocket test = new FoodAccessImplSocket();
        Food newFood = new Food(7, "Maruchan", FoodTypeEnum.ENTRADA);
        String response = test.createFood(newFood);
        assertEquals(response, "7");
        newFood = new Food(8, "Caldito de Pollo", FoodTypeEnum.PRINCIPIO);
        response = test.createFood(newFood);
        assertEquals(response, "8");
        
    }
    
    /**
     * Test del método de entrada del cliente para crear una comida.
     * En caso de que se lance una excepción
     */
    @Test(expected=Exception.class)
    public void testCreateFood2() throws Exception {
        FoodAccessImplSocket test = new FoodAccessImplSocket();
        Food newFood = new Food(1, "Maruchan", FoodTypeEnum.ENTRADA);
        String response = test.createFood(newFood);
    }
    
}
