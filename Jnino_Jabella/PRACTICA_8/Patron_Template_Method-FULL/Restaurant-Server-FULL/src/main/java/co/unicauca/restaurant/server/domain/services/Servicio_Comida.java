/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.server.domain.services;

import co.unicauca.restaurant.commons.domain.Food;
import java.util.List;
import co.unicauca.restaurant.server.access.Interface_Repositorio_Comida;

/**
 *
 * @author Libardo, Julio
 */
public class Servicio_Comida {
    /**
     * Dependencia abstracta al repositorio
     */
    private Interface_Repositorio_Comida repo;

    /**
     * Construcor parametrizado
     *
     * @param repo repositorio que es inyectado
     */
    public Servicio_Comida(Interface_Repositorio_Comida repo) {
        this.repo = repo;

    }

    /**
     * Crear una comida
     *
     * @param food comdia a crearse en la bd
     * @return 
     */
    public boolean create(Food food) {
        return repo.Crear(food);
    }

    /**
     * Modifica una comida
     *
     * @param food comida a ser grabada en la bd
     */
    public void update(Food food) {
        repo.Actualizar(food);
    }

    /**
     * Eliminar comida
     *
     * @param id identificador de la comida
     * @return 
     */
    public boolean delete(int id) {
        return repo.Eliminar(id);
    }

    /**
     * Buscar todas las comidas
     *
     * @return lista de comidas
     */
    public List<Food> findAll() {
        return repo.ListaComidas();
    }

    /**
     * Buscar comida por su id
     *
     * @param id identificador de la comida
     * @return Comida
     */
    public Food findByIdl(int id) {
        return repo.EncontrarPorID(id);
    }
}
