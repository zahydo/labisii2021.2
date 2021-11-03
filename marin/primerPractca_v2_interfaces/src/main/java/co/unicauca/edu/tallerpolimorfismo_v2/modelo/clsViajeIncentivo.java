package co.unicauca.edu.tallerpolimorfismo_v2.modelo;

import java.util.Date;

/**
 * Clase dedicada a los viajes incentivos por una empresa
 * @author David Marín
 */
public class clsViajeIncentivo extends clsViaje implements IDescripcion
{
    /**
     * atrEmpresa; atributo de tipo String. Empresa que incentiva un viaje
     */
    private String atrEmpresa;
    
    /**
     * Método constructor por defecto de clsViajeIncentivo
     */
    public clsViajeIncentivo(){}
    
    /**
     * Método constructor sobrecargado de clsViajeIncentivo
     * @param prmOrigen; parámetro de tipo String que inicializa el origen de un viaje
     * @param prmDestino; parámetro de tipo Strin que inicializa el destino de un viaje
     * @param prmCosto; parámetro de tipo int que inicializa el costo de un viaje
     * @param prmFechaSalida; parámetro de tipo Date que inicializa la fecha de salida de un viaje
     * @param prmFechaLlegada; parámetro de tipo Date que inicializa la fecha de llegada de un viaje
     * @param prmEmpresa; parámetro de tipo String que iniciliza la empresa que incentiva un viaje
     */
    public clsViajeIncentivo(String prmOrigen, String prmDestino, int prmCosto, Date prmFechaSalida, Date prmFechaLlegada, String prmEmpresa)
    {
        super(prmOrigen, prmDestino, prmCosto, prmFechaSalida, prmFechaLlegada);
        atrEmpresa = prmEmpresa;
    }
    
    /**
     * Método getter getEmpresa() de tipo String que muestra la empresa que incentiva un viaje
     * @return devuelve el nombre de la empresa
     */
    public String getEmpresa()
    {
        return atrEmpresa;
    }
    
    /**
     * Método setter setEmpresa() que modifica el nombre de la emopresa que incentiva un viaje
     * @param prmEmpresa; parámetro de tipo String que modifica la empresa
     */
    public void setEmpresa(String prmEmpresa)
    {
        atrEmpresa = prmEmpresa;
    }
    
    /**
     * Método abstracto de la interfaz IDescripcion
     * @return devuelve la descripción del viaje incentivo
     */
    @Override
    public String descripcion()
    {
        return "Viaje incentivo que te envia la empresa " + atrEmpresa;
    }
    
    /**
     * Método sobreescrito de la clase clsViaje
     * @return devuelve información de este método implementado en la clase clsViajeIncentivo
     */
    @Override
    public String cualquierMetodo2()
    {
        return "Método implementado en la clase hija viaje de incentivo";
    }
}
