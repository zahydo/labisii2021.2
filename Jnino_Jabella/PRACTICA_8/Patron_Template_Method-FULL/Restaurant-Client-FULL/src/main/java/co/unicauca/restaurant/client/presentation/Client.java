/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.unicauca.restaurant.client.presentation;

import co.unicauca.restaurant.client.access.Fabrica;
import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.commons.domain.FoodTypeEnum;
import co.unicauca.restaurant.client.access.Interface_Acceso_Comida;

/**
 *
 * @author Libardo, Julio
 */
public class Client {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Interface_Acceso_Comida service = Fabrica.getInstance().getFoodService();
        Food food = service.EncontrarComida(1);
        System.out.println(food.toString());
        Food newFood = new Food(5,"Arrocito Caliente",FoodTypeEnum.PRINCIPIO);
        String respuesta = service.CrearComida(newFood);
        System.out.println("Response: " + respuesta);
        Food findfood = service.EncontrarComida(4);
        System.out.println(findfood.toString());
    }
    
}
