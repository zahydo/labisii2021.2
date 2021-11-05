package co.unicauca.edu.tallerpolimorfismo_v2.modelo;

import java.util.Date;

/**
 * Clase dedicada a los viajes familiares. Hereda de la clase clsViaje
 * @author David Marín
 */
public class clsViajeFamiliar extends clsViaje implements IDescripcion
{
    /**
     * atrFamilia; atributo de tipo entero. Cantidad de miembros de la familia
     */
    private int atrFamilia;
    
    /**
     * Método constructor por defecto de clsViajeFamiliar
     */
    public clsViajeFamiliar(){}
    
    /**
     * Método constructor sobrecargado de clsViajeFamiliar
     * @param prmOrigen; parámetro de tipo String que inicializa el origen de un viaje
     * @param prmDestino; parámetreo de tipo String que inicializa el destino de un viaje
     * @param prmCosto; parámetro de tipo int que inicializa el costo de un viaje
     * @param prmFechaSalida; parámetro de tipo Date que inicializa la fecha de salida de un viaje
     * @param prmFechaLegada; parámetro de tipo Date que inicializa la fecha de Llegada de un viaje
     */
    public clsViajeFamiliar(String prmOrigen, String prmDestino, int prmCosto, Date prmFechaSalida, Date prmFechaLlegada, int prmFamilia)
    {
        super(prmOrigen, prmDestino, prmCosto, prmFechaSalida, prmFechaLlegada);
        atrFamilia = prmFamilia;
    }
    
    /**
     * Método getter getFamilia() muestra el número de miembros de una familia
     * @return devuelve el número de integrantes de la familia
     */
    public int getFamilia()
    {
        return atrFamilia;
    }
    
    /**
     * Método setter setFamilia() modifica el número de integrantes de una familia
     * @param prmFamilia; parámetro de tipo int que modifica el atributo atrFamilia
     */
    public void setFamilia(int prmFamilia)
    {
        atrFamilia = prmFamilia;
    }
    
    /**
     * Método de la interfaz IDescripcion que muestra la descripción de un viaje familiar
     * @return devuelve un mensaje para un viaje familiar
     */
    @Override
    public String descripcion() 
    {
        return "Viaje para disfrutar con toda tu familia";
    }
    
    /**
     * Método sobreescrito de la clase principal que hereda de la clase clsViaje
     * @return devuelve información de el método implementado en la clase clsViajeFamilia
     */
    @Override
    public String cualquierMetodo2()
    {
        return "Método implementado en la clase hija viaje familiar"; 
    }
}
