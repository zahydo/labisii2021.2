/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.domain.Food;
import java.util.List;

/**
 *
 * @author Sebastian_Arenas
 */
public interface IFoodRepository {
    /**
     * Buscar un cliente utilizando un socket
     *
     * @param id cedula del cliente
     * @return objeto cliente
     */
    public Food findById(int id);

    /**
     * Busca los n primeros registros
     *
     * @return lista de clientes
     */
    public List<Food> findAll();

    /**
     * Crea un Component
     *
     * @param customer cliente de la agencia de viajes
     * @return devuelve la cedula del cliente creado
     */
    public boolean create(Food customer);

    /**
     * Modifica un cliente
     *
     * @param customer cliente a ser modificado
     * @return true si lo modifica con exito, false en caso contrario
     */
    public boolean update(Food customer);

    /**
     * Eliminar un cliente
     *
     * @param id identificador del cliente a eliminar
     * @return true si elimina con exito,false en caso contrario
     */
    public boolean delete(int id);
}
