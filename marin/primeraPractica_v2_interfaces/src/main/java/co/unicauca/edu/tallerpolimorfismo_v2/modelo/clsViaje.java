
package co.unicauca.edu.tallerpolimorfismo_v2.modelo;

import java.util.Date;

/**
 * Clase clsViaje principal
 * @author David Marín
 */
public class clsViaje implements IDescripcion, ICualquierMetodo2
{
    /**
     * atrOrigen: atriburo de tipo String que relaciona el origen de un viaje 
     * atrDestino: atributo de tipo String que indica el destino de un viaje
     * atrCosto: aributo de tipo int que indica el costo de un viaje
     * atrFechaSalida: atributo de tipo Date que indica la fecha de salida de un viaje
     * atrFechaLlegada: atributo de tipo Date que indica la fecha de llegada de un viaje
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
     * 
     * @param prmOrigen; parámetro tipo String que recibe el origen de un viaje
     * @param prmDestino; parámetro tipo String que recibe el destino de un viaje
     * @param prmCosto; parámetro de tipo entero que recibe el costo de un vije
     * @param prmFechaSalida; parámetro de tipo Date que recibe la fecha de salida de un viaje
     * @param prmFechaLlegada; parámetro de tipo Date que recibe la fecha de llegada de un viaje
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
     * Método getter getOrigen() tipo String que devuelve el origen de un viaje
     * @return devuelve el nombre del origen
     */
    public String getOrigen()
    {
        return atrOrigen;
    }
    
    /**
     * Método setter setOrigen() que modifica el origen de un viaje
     * @param prmOrigen; parámetro de tipo String que modifica el origen
     */
    public void setOrigen(String prmOrigen)
    {
        atrOrigen = prmOrigen;
    }
    
    /**
     * Método getter getDestino() tipo String que muestra el destino de un viaje
     * @return devuelve el nombre del destino de un viaje
     */
    public String getDestino()
    {
        return atrDestino;
    }
    
    /**
     * Método setter setDestino() que modififca el destino de un viaje
     * @param prmDestino; parámetro de tipo String que modicia el destino
     */
    public void setDestino(String prmDestino)
    {
        atrDestino = prmDestino;
    }
    
    /**
     * Método getter getCosto() de tipo int que muestra el costo de un viaje
     * @return devuelve el costo
     */
    public int getCosto()
    {
        return atrCosto;
    }
    
    /**
     * Método setter setCosto() que modifica el costo de un viaje
     * @param prmCosto; parámetro de tipo entero que modicia el costo
     */
    public void setCosto(int prmCosto)
    {
        atrCosto = prmCosto;
    }
    
    /**
     * Método getter getFechaSalida() de tipo Date que muestra la fecha de salida de una viaje
     * @return devuelve la fecha de salida del viaje
     */
    public Date getFechaSalida()
    {
        return atrFechaSalida;
    }
    
    /**
     * Método setter setFechaSalida() que modifica la fecha de salida de un viaje
     * @param prmFechaSalida; parámetro de tipo Date que modifica la fecha de salida del viaje
     */
    public void setCosto(Date prmFechaSalida)
    {
        atrFechaSalida = prmFechaSalida;
    }
    
    /**
     * Método getter getFechaLlegada() que muestra la fecha de llegada de un viaje
     * @return devuelve la fecha de llegada del viaje
     */
    public Date getFechaLlegada()
    {
        return atrFechaLlegada;
    }
    
    /**
     * Método setter setFechaLlegada() que modifica la fecha de llegada de un viaje
     * @param prmFechaLlegada; parámetro de tipo Date que modifica la fecha de llegada del viaje
     */
    public void setFechaLlegada(Date prmFechaLlegada)
    {
        atrFechaLlegada = prmFechaLlegada;
    }
    
    /**
     * Método de tipo String que devuelve información acerca de un método implementado en la clase clsViaje
     * @return devuelve una cadena con un mensaje indicando dicha implementación
     */
    public String cualquierMetodo()
    {
        return "Cualquier método implementado en la clase base";
    }
    
    /**
     * Método de la interfaz IDescripcion; devuelve la descripción de la clase clsViaje
     * @return devuelve una cadena que indica que es un método dando información de la clas clsViaje
     */
    @Override
    public String cualquierMetodo2()
    {
        return "Cualquier método2 implementado en la clase base";
    }
    
    public String descripcion()
    {
        return "Descripción implementada en la clase base";
    }

}
