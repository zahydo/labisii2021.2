/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.foodapp.server.domain.services;

import co.unicauca.foodapp.commons.domain.Food;
import co.unicauca.foodapp.commons.domain.FoodTypeEnum;
import co.unicauca.foodapp.server.access.IFoodRepository;
import co.unicauca.foodapp.server.access.RepositoryFactory;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test FoodService
 * @author Andrés David Muñoz
 */
public class FoodServiceTest {
    
    private FoodService instance;  
    
    /**
     * Constructor por defecto 
     */
    public FoodServiceTest() {
        IFoodRepository repository = RepositoryFactory.getInstance().getRepository("default"); 
        instance = new FoodService(repository); 
    }

    /**
     * Test of create method, of class FoodService.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Food food = new Food(4,"Changua",FoodTypeEnum.ENTRADA); 
        String expResult = "Guardado con éxito" + food.toString();
        String result = instance.create(food);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class FoodService.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Food food = new Food(3,"Aguamasa",FoodTypeEnum.ENTRADA); 
        String expResult = "Actualizado con éxito" + food.toString();
        String result = instance.update(food);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of findByIdl method, of class FoodService.
     */
    @Test
    public void testFindByIdl() {
        System.out.println("findByIdl");
        int id = 3;
        Food expResult = new Food(3, "Jugo de mango", FoodTypeEnum.JUGO); 
        Food result = instance.findByIdl(id);
        assertEquals(expResult.toString(), result.toString());
    }
    
    /**
     * Test of findAll method, of class FoodService.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        int expResult = 3;
        List<Food> resultList = instance.findAll();
        int result = resultList.size();  
        assertEquals(expResult, result);
        
    }
    
    
    /**
     * Test of delete method, of class FoodService.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 2;
        String expResult = "Eliminado con éxito elemento " + String.valueOf(id);
        String result = instance.delete(id);
        assertEquals(expResult, result);
        
    }
}
