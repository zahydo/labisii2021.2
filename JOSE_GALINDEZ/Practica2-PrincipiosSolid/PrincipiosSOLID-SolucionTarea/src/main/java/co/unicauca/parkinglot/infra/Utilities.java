/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.infra;

/**
 * Herramientas de Utilidades para el parqueado
 * @author Jose_R
 */
public class Utilities {
    /**
     * Devuelve un valor redondeado al mayor
     * @param cost valor a redondear
     * @return valor redondeado al mayor
     */
    static public long redondeo(double cost) {

        if (cost % 100 == 0) {
            return (long) cost;
        }
        long aux = (long) (cost / 100) + 1;
        return aux * 100;
    }

}
