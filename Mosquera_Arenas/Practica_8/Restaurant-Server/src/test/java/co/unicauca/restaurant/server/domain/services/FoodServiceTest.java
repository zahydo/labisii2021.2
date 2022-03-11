/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.unicauca.restaurant.server.domain.services;

import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.commons.domain.FoodTypeEnum;
import co.unicauca.restaurant.server.access.RepositoryFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Sebastian_Arenas
 */
public class FoodServiceTest {
    
    public FoodServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of create method, of class FoodService.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Food food = new Food(4,"Lentejas",FoodTypeEnum.PRINCIPIO);
        FoodService instance = new FoodService(RepositoryFactory.getInstance().getRepository("default"));
        boolean expResult = true;
        boolean result = instance.create(food);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of findByIdl method, of class FoodService.
     */
    @Test
    public void testFindByIdl() {
        System.out.println("findByIdl");
        int id = 1;
        FoodService instance = new FoodService(RepositoryFactory.getInstance().getRepository("default"));;
        Food expResult = new Food(1, "Fríjoles", FoodTypeEnum.PRINCIPIO);
        Food result = instance.findByIdl(id);
        System.out.println(result);
        System.out.println(expResult);
        assertEquals(expResult.getNameFood(), result.getNameFood());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
