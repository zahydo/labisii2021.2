/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.infra.Utilities;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author David E
 */
public class CryptFood extends Food{
    
    
    private Food myDecoratedFood;
    
    /**
     * Costructor
     * @param id es el identificador
     * @param name es el nombre del plato
     * @param type es el tipo de plato
     */
    
    public CryptFood(int id, String name, FoodTypeEnum type) {
        //Lo convierte a mayúsculas
        String capitalizeFoodName = Utilities.capitalize(name);
        String cadenaEncriptada = Utilities.ecnode(capitalizeFoodName);
        myDecoratedFood = new Food(id, cadenaEncriptada, type);
    }
    

    @Override
    public void setName(String name) {
        String cadenaEncriptada = Utilities.ecnode( name.toUpperCase());
        myDecoratedFood.setName(cadenaEncriptada);
    }

    @Override
    public String getName() {
        return myDecoratedFood.getName();
    }

    /**
     *
     * @return Id del plato
     */
    @Override
    public int getId() {
        return myDecoratedFood.getId();
    }

    @Override
    public void setId(int id) {
        myDecoratedFood.setId(id);
    }

    @Override
    public FoodTypeEnum getType() {
        return myDecoratedFood.getType();
    }

    @Override
    public void setType(FoodTypeEnum type) {
        myDecoratedFood.setType(type);
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + myDecoratedFood.getId() + ", name=" + myDecoratedFood.getName() + ", type=" + myDecoratedFood.getType() + '}';
    }
    
    
}
