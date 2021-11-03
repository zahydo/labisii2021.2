package co.unicauca.edu.tallerpolimorfismo.modelo;

import java.util.Date;

/**
 * clsViaje superclase que contien información común de las subclases
 * @author David Marín
 */
public abstract class clsViaje 
{
    /**
     * Atributo atrOrigen de tipo String del origen del viaje
     * Atributo atrDestino de tipo String del destino de llegada del viaje
     * Atributo atrCosto de tipo int que contiene el costo del viaje
     * Atributo atrFechaSalida de tipo Date de la fecha de salida del viaje
     * Atributo atrFechaLlegada de tipo Date de la fecha de llegada del viaje
     */
    protected String atrOrigen;
    protected String atrDestino;
    protected int atrCosto;
    protected Date atrFechaSalida;
    protected Date atrFechaLlegada;
    
    /**
     * Método constructor por defecto de la clase clsViaje
     */
    public clsViaje(){}
    
    /**    
     * Método constructor sobrecargado de la clase clsViaje
     * @param prmOrigen parámetro de tipo String del origen del viaje
     * @param prmDestino parámetro de tipo String del destino del viaje
     * @param prmCosto parámetro de tipo entero del costo del viaje
     * @param prmFechaSalida parámetro de tipo Date de la fecha de salida del viaje
     * @param prmFechaLlegada parámetro de tipo Date de la llegada del viaje
    */
    public clsViaje(String prmOrigen, String prmDestino, int prmCosto, Date prmFechaSalida, Date prmFechaLlegada)
    {
        atrOrigen = prmOrigen;
        atrDestino = prmDestino;
        atrCosto = prmCosto;
        atrFechaSalida = prmFechaSalida;
        atrFechaLlegada = prmFechaLlegada;
    }
    
    /**
     * Método getter getOrigen() de tipo String que retorna el origen del viaje
     * @return devuelve el origen del viaje
     */
    public String getOrigen()
    {
        return atrOrigen;
    }
    
    /**
     * Método setter setOtigen(String) que modifica un origen del viaje
     * @param prmOrigen parámetro de tipo String que modifica un origen del viaje
     */
    public void setOrigen(String prmOrigen)
    {
        atrOrigen = prmOrigen;
    }
    
    /**
     * Método getter getDestino() de tipo String que devuelve el destino del viaje
     * @return devuelve el destino de llegada del viaje
     */
    public String getDestino()
    {
        return atrDestino;
    }
    
    /**
     * Método setter setDestino(String) que modifica el destino del viaje
     * @param prmDestino parámetro de tipo String que modifica un destino del viaje
     */
    public void setDestino(String prmDestino)
    {
        atrDestino = prmDestino;
    }
    
    /**
     * método getter getCosto() de tipo entero que devuelve el costo de un viaje
     * @return devuelve al costo del viaje
     */
    public int getCosto()
    {
        return atrCosto;
    }
    
    /**
     * Método setter setCosto(int) de tipo entero que modifica el costo de un viaje
     * @param prmCosto parámetro de tipo entero que modifica un costo 
     */
    public void setCosto(int prmCosto)
    {
        atrCosto = prmCosto;
    }
    
    /**
     * Método getter getFechaSalida() de tipo Date que devuelve la fecha de una salida
     * @return devuelve la fecha de salida del viaje
     */
    public Date getFechaSalida()
    {
        return atrFechaSalida;
    }
          
    /**
     * Método setter setFechaSalida(Date) que modifica la fecha de salida de un viaje
     * @param prmFechaSalida parámetro de tipo Date que modifica una fecha de salida
     */
    public void setFechaSalida(Date prmFechaSalida)
    {
        atrFechaSalida = prmFechaSalida;
    }
    
    /**
     * Método getter getFechaLlegada() que devuelve la fecha de llegada de un viaje
     * @return devuelve la fecha de llegada del viaje
     */
    public Date getFechaLlegada()
    {
        return atrFechaLlegada;
    }
    
    /**
     * Método setter setFechaLlegada(Date) que modifica una fecha de llegada
     * @param prmFechaLlegada parámetro de tipo Date que modifica la fecha de llegada
     */
    public void setFechaLlegada(Date prmFechaLlegada)
    {
        atrFechaLlegada = prmFechaLlegada;
    }
    
    /**
     * Método abstracto descripcion() de tipo String que describe el viaje 
     */
    public abstract String descripcion();
    
    /***
     * Método cualquierMetodo() de tipo String que returna información de la clase base
     * @return devuelve una cadena especificando información de la clase base
     */
    public String cualquierMetodo()
    {
        return "Cualquier método implementado en la clase base";
    }
    
    /**
     * Método cualquierMetodo2() de tipo String que retorna información de la clase base
     * @return devuelve una cadena escpecificando información de la clase base
     */
    public String cualquierMetodo2()
    {
        return "Cualquier método2 implementado en la clase base";
    }
}
