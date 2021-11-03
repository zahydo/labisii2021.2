package co.unicauca.edu.tallerpolimorfismo.modelo;

import java.util.Date;

/**
 * clsViajeIndividual dedicado para disfrutar de un plan de viaje individual
 * @author David Marín
 */
public class clsViajeIndividual extends clsViaje
{
    /**
     * Método constructor por defecto de la clase clsViajeIndividual
     */
    public clsViajeIndividual(){}
    
    /**
     * Método constructor sobrecargado de la clase clsViajeIndividual
     * @param prmOrigen; parámetro de tipo String que inicializa el origen de un viaje
     * @param prmDestino; parámetro de tipo String que inicializa el destino de un viaje
     * @param prmCosto; parámetro de tipo entero que inicializa el costo de un viaje
     * @param prmFechaSalida; parámetro de tipo Date que inicializa la salida de un viaje
     * @param prmFechaLlegada; parámetro de tipo Date que inicializa la llegada de un viaje
     */
    public clsViajeIndividual(String prmOrigen, String prmDestino, int prmCosto, Date prmFechaSalida, Date prmFechaLlegada)
    {
        super(prmOrigen, prmDestino, prmCosto, prmFechaSalida, prmFechaLlegada);
    }
    
    /**
     * Método sobreescrito de tipo String que la clase clsViaje que brinda información sobre el viaje
     * @return devuelve una cadena sobre la información de este viaje.
     */
    @Override 
    public String descripcion()
    {
        return "Disfruta tu viaje individual";
    }
}
