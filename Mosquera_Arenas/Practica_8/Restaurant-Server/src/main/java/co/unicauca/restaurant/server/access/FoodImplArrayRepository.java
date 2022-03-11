/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.commons.domain.FoodTypeEnum;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian_Arenas
 */
public class FoodImplArrayRepository implements IFoodRepository{
    private static List<Food> components;

    public FoodImplArrayRepository() {
        if (components == null) {
            components = new ArrayList<>();
            initData();
        }
    }

    private void initData() {
        components.add(new Food(1, "Fríjoles", FoodTypeEnum.PRINCIPIO));
        components.add(new Food(2, "Sopa de verduras", FoodTypeEnum.ENTRADA));
        components.add(new Food(3, "Jugo de mango", FoodTypeEnum.JUGO));

    }

    @Override
    public Food findById(int id) {
        for (Food comp : components) {
            if (comp.getIdFood() == id) {
                return comp;
            }
        }
        return null;
    }

    @Override
    public boolean create(Food component) {
        System.out.println("Se añadidio la comida :"+ component.toString());
        components.add(component);
        return true;
    }

    @Override
    public boolean update(Food component) {
        for (Food componentAux : components) {
            if (componentAux.getIdFood() == component.getIdFood()) {
                //Modificamos sus datos
                componentAux.setNameFood(component.getNameFood());
                componentAux.setType(component.getType());
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean delete(int id) {
        int i = 0;
        for (Food componentAux : components) {
            if (componentAux.getIdFood() == id) {
                components.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }

    /**
     * Busca los n primeros registros de clientes
     *
     * @return lista de clientes
     */
    @Override
    public List<Food> findAll() {
        return components;
    }
}
