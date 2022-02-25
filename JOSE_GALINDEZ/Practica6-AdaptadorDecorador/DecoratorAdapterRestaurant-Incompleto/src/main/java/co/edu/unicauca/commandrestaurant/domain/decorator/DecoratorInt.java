/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;

/**
 *
 * @author Jose Ricardo
 */
public interface DecoratorInt {

    /**
     *
     * @return Id del plato
     */
    int getId();

    String getName();

    FoodTypeEnum getType();

    void setId(int id);

    void setName(String name);

    void setType(FoodTypeEnum type);

    String toString();
    
}
