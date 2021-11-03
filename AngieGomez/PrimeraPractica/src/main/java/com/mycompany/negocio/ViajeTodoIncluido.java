package com.mycompany.negocio;

import java.util.Date;

/**
 *
 * @author Libardo Pantoja
 */
public class ViajeTodoIncluido extends Viaje {

    public ViajeTodoIncluido(String origen, String destino, int costo, Date fechaSalida, Date fechaLlegada) {
        super(origen, destino, costo, fechaSalida, fechaLlegada);
    }
    
    // Constructores

    @Override
    public String descripcion() {
        return "Disfruta tu viaje todo incluido";
    }
    //No se sobreescribe cualquierMetodo2()
}
