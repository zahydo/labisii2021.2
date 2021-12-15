package co.unicauca.edu.tallerpolimorfismo.modelo;

import java.util.Date;

/**
 * clsViajeFamiliar dedicado para un viaje exclusivo para una familia
 * @author David Marín
 */
public class clsViajeFamiliar extends clsViaje
{
    /**
     * Atrbuto atrFamilia; cantidad de integrantes de la familia
     */
    private int atrFamilia;
    
    /**
     * Método constructor por defecto de la clase clsViajeFamiliar
     */
    public clsViajeFamiliar(){}
    
    /**
     * Método constructor sobrecargado de la clase clsViajeFamiliar
     * @param prmOrigen; parámetro de tipo String que inicializa el origen de un viaje
     * @param prmDestino; parámetro de tipo String que inicializa el destino de un viaje
     * @param prmCosto; parámetro de tipo int que inicializa el costo de un viaje
     * @param prmFechaSalida; parámetro de tipo Date que inicializa la salida de un viaje
     * @param prmFechaLlegada; parámetro de tipo Date que inicializa la llegada de un viaje
     * @param prmFamilia; parámetro de tipo entero que inicializa el número de integrantes de una familia
     */
    public clsViajeFamiliar(String prmOrigen, String prmDestino, int prmCosto, Date prmFechaSalida, Date prmFechaLlegada, int prmFamilia)
    {
        super(prmOrigen, prmDestino, prmCosto, prmFechaSalida, prmFechaLlegada);
        atrFamilia = prmFamilia;
    }
    
    /**
     * Método getter getFamilia(); retorna el número de integrantes de una familia
     * @return devuelve un entero que es la cantidad de integrantes de una familia
     */
    public int getFamilia()
    {
        return atrFamilia;
    }
    
    /**
     * Método setter setFamilia(int); método setter que modifica los integrantes de una familia
     * @param prmFamilia; parámetro de tipo entero que modifica el atriburto atrFamilia de una familia
     */
    public void setFamilia(int prmFamilia)
    {
        atrFamilia = prmFamilia;
    }
    
    /**
     * Método público de tipo String sobreescrito de la clase base clsViaje
     * @return devuelve una cadena osbre la descripción de este viaje
     */
    @Override
    public String descripcion()
    {
        return "Viaje para disfrutar con toda tu familia";
    }
    
    /**
     * Método público sobreescrito de tipo String dedicado a esta subclase clsViajeFamiliar
     * @return devuelve una cadena de la descripción de este viaje
     */
    @Override
    public String cualquierMetodo2()
    {
        return "Método implementado en la clase hija viaje familiar";
    }
}