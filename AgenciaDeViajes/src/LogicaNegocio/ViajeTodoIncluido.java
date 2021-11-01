package LogicaNegocio;

import java.util.Date;

/**
 *
 * @author Dz
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
