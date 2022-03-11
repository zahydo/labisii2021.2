/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.server.domain.services;

import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.server.access.IFoodRepository;
import java.util.List;

/**
 *
 * @author Sebastian_Arenas
 */
public class FoodService {
    /**
     * Dependencia abstracta al repositorio
     */
    private IFoodRepository repo;

    /**
     * Construcor parametrizado
     *
     * @param repo repositorio que es inyectado
     */
    public FoodService(IFoodRepository repo) {
        this.repo = repo;

    }

    /**
     * Crear una comida
     *
     * @param food comdia a crearse en la bd
     * @return 
     */
    public boolean create(Food food) {
        return repo.create(food);
    }

    /**
     * Modifica una comida
     *
     * @param food comida a ser grabada en la bd
     */
    public void update(Food food) {
        repo.update(food);
    }

    /**
     * Eliminar comida
     *
     * @param id identificador de la comida
     * @return 
     */
    public boolean delete(int id) {
        return repo.delete(id);
    }

    /**
     * Buscar todas las comidas
     *
     * @return lista de comidas
     */
    public List<Food> findAll() {
        return repo.findAll();
    }

    /**
     * Buscar comida por su id
     *
     * @param id identificador de la comida
     * @return Comida
     */
    public Food findByIdl(int id) {
        return repo.findById(id);
    }
}
