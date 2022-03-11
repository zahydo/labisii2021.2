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
 * 
 * @author Diego Collazos, Eliana Cerquera
 */
public class FoodServiceTest {
    
    /**
     * Instancia del servicio de comidas
     */
    private FoodService instance;
    
    /**
     * Constructor por defecto
     */
    public FoodServiceTest() {
        IFoodRepository repository = RepositoryFactory.getInstance().getRepository("default"); 
        instance = new FoodService(repository); 
    }

    /**
     * Test para crear una comida usando FoodService
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Food food = new Food(4, "Frijolitos", FoodTypeEnum.ENTRADA); 
        String expResult = "Guardado con éxito" + food.toString();
        String result = instance.create(food);
        assertEquals(expResult, result);
    }

    /**
     * Test para modificar una comida usando FoodService
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Food food = new Food(3, "Jugo de mora", FoodTypeEnum.ENTRADA); 
        String expResult = "Actualizado con éxito" + food.toString();
        String result = instance.update(food);
        assertEquals(expResult, result);
    }
    
    /**
     * Test para encontrar una comida por id usando FoodService
     */
    @Test
    public void testFindByIdl() {
        System.out.println("findById");
        int id = 3;
        Food expResult = new Food(3, "Jugo de mango", FoodTypeEnum.JUGO); 
        Food result = instance.findById(id);
        assertEquals(expResult.toString(), result.toString());
    }
    
    /**
     * Test para listar las comidas usando FoodService
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
     * Test para eliminar una comida usando FoodService
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
