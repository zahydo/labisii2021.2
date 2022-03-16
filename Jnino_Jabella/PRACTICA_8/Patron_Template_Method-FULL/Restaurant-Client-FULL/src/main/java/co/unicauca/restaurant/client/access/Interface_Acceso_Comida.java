/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.commons.domain.Food;

/**
 *
 * @author Libardo, Julio
 */
public interface Interface_Acceso_Comida {

    /**
     *
     * Metodo que encuentra una comida con un socket.
     *
     * @param prmID cedula del cliente
     * @return objeto cliente
     * @throws Exception error al buscar un cliente
     */
    public Food EncontrarComida(int prmID) throws Exception;

    public String CrearComida(Food food) throws Exception;
}
