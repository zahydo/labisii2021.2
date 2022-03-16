/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.commons.infra.Utilities;

/**
 *
 * @author Libardo, Julio
 */
public class Fabrica {

    private static Fabrica instance;

    private Fabrica() {
    }

    /**
     * Patron Singleton
     *
     * @return retorna la instancia del atributo de tipo Fabrica
     */
    public static Fabrica getInstance() {

        if (instance == null) {
            instance = new Fabrica();
        }
        return instance;

    }

    /**
     * Metodo que obtiene un objeto de la interfaz de acceso con ayuda del
     * food.service
     *
     * @return Objeto de tipo Interface_Acceso_Comida
     */
    public Interface_Acceso_Comida getFoodService() {

        Interface_Acceso_Comida result = null;
        String type = Utilities.loadProperty("food.service");

        switch (type) {
            case "default":
                result = new Acceso_Comida_Sockets();
                break;
        }

        return result;
    }
}
