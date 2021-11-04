/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author 57322
 */
public class ViajeTodoIncluido extends Viaje {

    /**
     * Constructor parametrizado
     *
     * @param origen
     * @param destino
     * @param costo
     * @param fechaSalida
     * @param fechaLlegada
     */
    public ViajeTodoIncluido(String origen, String destino, int costo, Date fechaSalida, Date fechaLlegada) {
        super(origen, destino, costo, fechaSalida, fechaLlegada);
    }

    /*Constructor vacío*/
    public ViajeTodoIncluido() {

    }

    @Override
    public String descripcion() {
        return "Disfruta tu viaje todo incluido";
    }

}
