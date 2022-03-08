/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.unicauca.restaurant.server.services;

import co.unicauca.restaurant.server.access.Factory;
import co.unicauca.restaurant.server.access.IFoodRepository;
import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.commons.domain.FoodTypeEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author David E
 */
public class FoodServiceTest {
    
    /**
     * Test of create method, of class FoodService.
     */
    @Test
    public void testCreate() {
        
        System.out.println("create");
        Food food = new Food(10,"Frijoles rojos",FoodTypeEnum.ENTRADA);
        IFoodRepository repo = Factory.getInstance().getRepository("default");
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

        System.out.println("findByIdl");
        int id = 1;
        IFoodRepository repo = Factory.getInstance().getRepository("default");
        FoodService instance = new FoodService(repo);
        Food result = instance.findByIdl(id);
        int expResult = 1;
        assertEquals(expResult, result.getId());
        
        // Customer que no existe
        result = instance.findByIdl(10);
        assertEquals(null, result);
    }
    
}
