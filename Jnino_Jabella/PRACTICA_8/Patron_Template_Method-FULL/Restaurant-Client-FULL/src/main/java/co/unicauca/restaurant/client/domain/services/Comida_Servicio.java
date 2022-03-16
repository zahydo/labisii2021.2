/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.client.domain.services;

import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.client.access.Interface_Acceso_Comida;


/**
 *
 * @author Libardo, Julio
 */
public class Comida_Servicio {
    private final Interface_Acceso_Comida atrAccesoComida;
    
    public Comida_Servicio(Interface_Acceso_Comida service) {
        this.atrAccesoComida = service;
    }
    
    
    public Food EncontrarComida(int prmID) throws Exception {
        return atrAccesoComida.EncontrarComida(prmID);

    }
    
    public String createFood(Food food) throws Exception {
        return atrAccesoComida.CrearComida(food);

    }
}
