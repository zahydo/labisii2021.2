/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.utilidades;

import co.unicauca.parkinglot.domain.TypeEnum;

/**
 *
 * @author mandr
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
            case "CARRO":
                return TypeEnum.CAR;
            case "MOTO":
                return TypeEnum.MOTO;
            case "CAMION":
                return TypeEnum.TRUCK;
        }
        return null;
    }
}
