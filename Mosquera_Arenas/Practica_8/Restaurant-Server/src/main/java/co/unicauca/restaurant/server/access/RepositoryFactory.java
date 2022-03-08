/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.server.access;

/**
 *
 * @author Sebastian_Arenas
 */
public class RepositoryFactory {
    private static RepositoryFactory instance;

    private RepositoryFactory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static RepositoryFactory getInstance() {

        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IProductRepository
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción IProductRepository
     */
    public IFoodRepository getRepository(String type) {

        IFoodRepository result = null;

        switch (type) {
            case "default":
                result = new FoodImplArrayRepository();
                break;
        }

        return result;

    }
}
