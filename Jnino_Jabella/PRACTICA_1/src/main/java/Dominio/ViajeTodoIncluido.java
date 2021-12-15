package Dominio;

import java.util.Date;

/**
 *
 * @author Juan Fernando Abella, Julian Andres Niño Niño
 */
public class ViajeTodoIncluido extends Viaje {

    // Constructores   
    public ViajeTodoIncluido(String origen, String destino, int costo, Date fechaSalida, Date fechaLlegada) {
        super(origen, destino, costo, fechaSalida, fechaLlegada);
    }

    @Override
    public String descripcion() {
        return "Disfruta tu viaje todo incluido";
    }

}