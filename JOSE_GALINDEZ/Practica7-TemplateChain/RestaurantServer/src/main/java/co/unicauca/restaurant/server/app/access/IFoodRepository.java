/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.restaurant.server.app.access;

import co.unicauca.restaurant.common.domain.Food;


/**
 *
 * @author Jose Ricardo
 */
public interface IFoodRepository {

    public String create(Food food);

    public Food findById(int id);
}
