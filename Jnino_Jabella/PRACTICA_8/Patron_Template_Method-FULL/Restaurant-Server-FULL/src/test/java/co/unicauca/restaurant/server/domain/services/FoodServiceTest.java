/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.unicauca.restaurant.server.domain.services;

import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.commons.domain.FoodTypeEnum;
import co.unicauca.restaurant.server.access.Fabrica_Repositorio;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Juan F , Julian Niño
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
     * Test del metodo crear , de la clase class Servicio_Comida.
     */
    @Test
    public void testCrear() {
        System.out.println("PRUEBA DE CREACION");
        Food food = new Food(6,"Maicitos",FoodTypeEnum.PRINCIPIO);
        Servicio_Comida instance = new Servicio_Comida(Fabrica_Repositorio.getInstance().getRepository("default"));
        boolean expResult = true;
        boolean result = instance.create(food);
        assertEquals(expResult, result);
      
    }


    /**
     * Test de EncontrarPorid de la clase Servicio_Comida.
     */
    @Test
    public void testEncontrarPorId() {
        System.out.println("PRUEBA ENCONTRAR POR ID");
        int id = 1;
        Servicio_Comida instance = new Servicio_Comida(Fabrica_Repositorio.getInstance().getRepository("default"));;
        Food expResult = new Food(1, "sopa de iguana", FoodTypeEnum.PRINCIPIO);
        Food result = instance.findByIdl(id);
        System.out.println(result);
        assertEquals(expResult.getNameFood(), result.getNameFood());
    }
    
     /**
     * Test de EliminarPorId de la clase Servicio_Comida.
     */
    @Test
    public void ElminiarPorId() {
        System.out.println("Eliminar por id");
        int id = 1;
        Servicio_Comida instance = new Servicio_Comida(Fabrica_Repositorio.getInstance().getRepository("default"));;
        Food expResult = new Food(1, "sopa de iguana", FoodTypeEnum.PRINCIPIO);
        boolean prueba = instance.delete(id);
        int result  = instance.findAll().size();
        System.out.println("SE ELIMINO LA COMIDA CON ID :"+id+" Por tanto el Menu tiene : "+ result+" Comidas");
       
        assertEquals(prueba, true);
    }
    
    
    
}
