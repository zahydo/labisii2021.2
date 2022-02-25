/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.infra.Utilities;

/**
 *
 * @author Jose Ricardo
 */
public class CryptFood extends Food implements DecoratorInt {

    private Food myCryptFood;

    public CryptFood(int id, String name, FoodTypeEnum type) {
        //Lo Encripta
        String Cryptname = Utilities.encriptar(name);
        myCryptFood = new Food(id, Cryptname, type);
        
    }

    @Override
    public void setName(String name) {

        myCryptFood.setName(Utilities.encriptar(name));

    }

    @Override
    public String getName() {
        //return Utilities.desencriptar(myCryptFood.getName());
        return myCryptFood.getName();
    }

    /**
     *
     * @return Id del plato
     */
    @Override
    public int getId() {
        return myCryptFood.getId();
    }

    @Override
    public void setId(int id) {
        myCryptFood.setId(id);
    }

    @Override
    public FoodTypeEnum getType() {
        return myCryptFood.getType();
    }

    @Override
    public void setType(FoodTypeEnum type) {
        myCryptFood.setType(type);
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + myCryptFood.getId() + ", name=" + myCryptFood.getName() + ", type=" + myCryptFood.getType() + '}';
    }

}
