package co.unicauca.tallerpolimorfismo.modelo;

import java.util.Date;

/**
 *
 * @author Sebastian
 */
public class ViajeTodoIncluido extends Viaje {
// Constructores

    public ViajeTodoIncluido(String origen, String destino, int costo, Date fechaSAlida, Date fachaLlegada) {
        super(origen, destino, costo, fechaSAlida, fachaLlegada);
    }

    @Override
    public String descripcion() {
        return "Disfruta tu viaje todo incluido";
    }
//No se sobreescribe cualquierMetodo2()
}
