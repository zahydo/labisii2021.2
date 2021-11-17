/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.infra;

import co.unicauca.parkinglot.domain.TypeEnum;

/**
 *
 * @author fermt
 */
public class Utilities {

    // Singleton
    private static Utilities instance;

    private Utilities() {
    }

    /**
     * Devuelve la instancia de la clase
     *
     * @return instancia unica de Utilities
     */
    public static Utilities getInstance() {
        if (instance == null) {
            instance = new Utilities();
        }
        return instance;
    }

    /**
     * Convierte de typeEnum a string los tipos de vehiculo
     *
     * @param type
     * @return TypeEnum
     */
    public static TypeEnum string_to_enum(String type) {
        switch (type) {
            case "CAR":
                return TypeEnum.CAR;
            case "MOTO":
                return TypeEnum.MOTO;
            case "TRUCK":
                return TypeEnum.TRUCK;
        }
        return null;
    }
}
