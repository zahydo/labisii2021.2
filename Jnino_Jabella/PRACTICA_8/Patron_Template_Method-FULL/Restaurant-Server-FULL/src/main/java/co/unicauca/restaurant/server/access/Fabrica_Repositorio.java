/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.server.access;

/**
 *
 * @author Libardo, Julio
 */
public class Fabrica_Repositorio {

    private static Fabrica_Repositorio instance;

    private Fabrica_Repositorio() {
    }

    /**
     * Patron singleton
     *
     * @return una instancia de tipo Fabrica_Repositorio.
     */
    public static Fabrica_Repositorio getInstance() {

        if (instance == null) {
            instance = new Fabrica_Repositorio();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IProductRepository
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción IProductRepository
     */
    public Interface_Repositorio_Comida getRepository(String type) {

        Interface_Repositorio_Comida result = null;

        switch (type) {
            case "default":
                result = new Comida_Repositorio();
                break;
        }

        return result;

    }
}
