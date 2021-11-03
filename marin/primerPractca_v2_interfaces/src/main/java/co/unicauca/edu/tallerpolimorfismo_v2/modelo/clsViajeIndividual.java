
package co.unicauca.edu.tallerpolimorfismo_v2.modelo;

import java.util.Date;

/**
 * Clase dedicada a los viajes individuales
 * @author David Marín
 */
public class clsViajeIndividual extends clsViaje implements IDescripcion
{
    /**
     * Método constructor por defecto de clsViajeIndividual
     */
    public clsViajeIndividual(){}
    
    /**
     * Método constructor sobrecargado de clsViajeIndividual
     * @param prmOrigen; parámetro de tipo String que inicializa el origen de un viaje
     * @param prmDestino; parámetro de tipo String que inicializa el destino de un viaje
     * @param prmCosto; parámetro de tipo int que inicializa el costo de un viaje
     * @param prmFechaSalida; parámetro de tipo Date inicializa la fecha de salida de un viaje
     * @param prmFechaLlegada; parámetro de tipo Date que inicializa la fecha de llegada de un viaje
     */
    public clsViajeIndividual(String prmOrigen, String prmDestino, int prmCosto, Date prmFechaSalida, Date prmFechaLlegada)
    {
        super(prmOrigen, prmDestino, prmCosto, prmFechaSalida, prmFechaLlegada);
    }
    
    /**
     * Método abstracto procedente de la interfaz IDescripcion
     * @return devuelve la descripción del viaje individual
     */
    @Override
    public String descripcion()
    {
        return "Disfruta tu viaje individual";
    }
}
