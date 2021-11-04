/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Date;

public class ViajeTodoIncluido extends Viaje {

    public ViajeTodoIncluido(String origen, String destino, int costo, Date salida, Date llegada) {
        super(origen, destino, costo, salida, llegada);
    }

    @Override
    public String descripcion() {
     return "Disfruta tu viaje todo incluido";
    }
}
