/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.domain.Food;
import java.util.List;

/**
 *
 * @author Libardo, Julio
 */
public interface Interface_Repositorio_Comida {

    /**
     * Buscar un cliente utilizando un socket
     *
     * @param id cedula del cliente
     * @return objeto cliente
     */
    public Food EncontrarPorID(int id);

    /**
     * Busca los n primeros registros
     *
     * @return lista de clientes
     */
    public List<Food> ListaComidas();

    /**
     * Crea un Component
     *
     * @param customer cliente de la agencia de viajes
     * @return devuelve la cedula del cliente creado
     */
    public boolean Crear(Food customer);

    /**
     * Actualiza un cliente
     *
     * @param customer cliente a ser modificado
     * @return true or false dependiendo si se hizo la operacion.
     */
    public boolean Actualizar(Food customer);

    /**
     * Eliminar un cliente
     *
     * @param id identificador del cliente a eliminar
     * @return true or false dependiendo si se hizo la operacion.
     */
    public boolean Eliminar(int id);
}
