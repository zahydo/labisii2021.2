/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.unicauca.commandRestaurant.infra.Utilities;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paula
 */
public class CryptFood extends Food {

    /**
     * Decorator Food
     */
    private Food myDecoratedFood;

    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param type
     */
    public CryptFood(int id, String name, FoodTypeEnum type) {
        try {
            String cryptFoodName = Utilities.encrypt(name);
            myDecoratedFood = new Food(id, cryptFoodName, type);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CryptFood.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + myDecoratedFood.getId() + ", name=" + myDecoratedFood.getName() + ", type=" + myDecoratedFood.getType() + '}';
    }

    /**
     *
     * @param type
     */
    @Override
    public void setType(FoodTypeEnum type) {
        myDecoratedFood.setType(type);
    }

    @Override
    public FoodTypeEnum getType() {
        return myDecoratedFood.getType();
    }

    /**
     *
     * @param name
     */
    @Override
    public void setName(String name) {
        myDecoratedFood.setName(name);
    }

    @Override
    public String getName() {
        return myDecoratedFood.getName();
    }

    /**
     *
     * @param id
     */
    @Override
    public void setId(int id) {
        myDecoratedFood.setId(id);
    }

    @Override
    public int getId() {
        return myDecoratedFood.getId();
    }

}
