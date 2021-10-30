package co.unicauca.edu.tallerpolimorfismo.modelo;

import java.util.Date;
/**
 * clsViajeTodoIncluido dedicado para viajes que incluyen todo el valor del viaje
 * @author David Marín
 */
public class clsViajeTodoIncluido extends clsViaje
{
    /**
     * Método constructor por defecto de la clase clsViajeTodoIncluido
     */
    public clsViajeTodoIncluido(){}
    
    /**
     * Método constructor sobrecargado de la clase clsViajeTodoIncluido
     * @param prmOrigen; parámetro de tipo String del origen de un viaje
     * @param prmDestino; parámetro de tipo String del destino de un viaje
     * @param prmCosto; parámetro de tipo int del costo de un viaje
     * @param prmFechaSalida; parámetro de tipo Date de la fecha de salida de un viaje
     * @param prmFechaLlegada; parámetro de tipo Date de la fecha de llegada de un viaje
     */
    public clsViajeTodoIncluido(String prmOrigen, String prmDestino, int prmCosto, Date prmFechaSalida, Date prmFechaLlegada)
    {
        super(prmOrigen, prmDestino, prmCosto, prmFechaSalida, prmFechaLlegada);
    }
    
    /**
     * Método público de tipo String que devuelve información la clase clsViajeTodoIncluido
     * @return devuelve una cadena sobre la descripción de este viaje
     */
    @Override
    public String descripcion()
    {
        return "Disfruta tu viaje todo incluido";
    }
}
