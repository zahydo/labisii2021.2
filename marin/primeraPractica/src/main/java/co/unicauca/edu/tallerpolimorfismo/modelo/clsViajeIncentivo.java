package co.unicauca.edu.tallerpolimorfismo.modelo;

import java.util.Date;

/**
 * clsViajeIncentivo dedicado para un viaje que una empresa para para un empleado
 * @author David Marín
 */
public class clsViajeIncentivo extends clsViaje
{
    /**
     *Atributo atrEmpresa que patrocina el viaje de un empleado
     */
    private String atrEmpresa;
    
    /**
     * Constructor por defecto de la clase clsViajeIncentivo
     */
    public clsViajeIncentivo(){}
    
    /**
     * Constructor sobrecargado de la clase clsViajeIncentivo
     * @param prmOrigen; parámetro de tipo String que inicializa el orgen de un viaje
     * @param prmDestino; parámetro de tipo String que inicializa el destino de un viaje
     * @param prmCosto; parámetro de tipo int que inicializa el costo de un viaje
     * @param prmFechaSalida; parámetro de tipo Date que inicializa la fecha de salida de una viaje
     * @param prmFechaLlegada; parámetro de tipo Date que inicializa la fecga de llegada de un viaje
     * @param prmEmpresa; parámetro de tipo String que inicializa el nombre de la empresa patrocinadora
     */
    public clsViajeIncentivo(String prmOrigen, String prmDestino, int prmCosto, Date prmFechaSalida, Date prmFechaLlegada, String prmEmpresa)
    {
        super(prmOrigen, prmDestino, prmCosto, prmFechaSalida, prmFechaLlegada);
        atrEmpresa = prmEmpresa;
    }
    
    /**
     * Método getter getEmpresa() que da el nombre de la empresa que patrocina el viaje
     * @return devuelve una cadena con el nombre de la empresa que patrocina el viaje
     */
    public String getEmpresa()
    {
        return atrEmpresa;
    }
    
    /**
     * Método setter setEmpresa(String) que modifica la empresa que patrocina el viaje
     * @param prmEmpresa; parámetro de tipo String que modifica la empresa que patrocina el viaje
     */
    public void setEmpresa(String prmEmpresa)
    {
        atrEmpresa = prmEmpresa;
    }
    
    /**
     * Método sobreescrito de tipo String de la clase clsViaje
     * @return devuelve una cadena con la información de la empresa que patrocina el viaje incentivo*/
    @Override
    public String descripcion()
    {
        return "Viaje incentivo que te envia la empresa " + atrEmpresa;
    }
    
    /**
     * Método público sobreescrito de tipo String dedicado a esta subclase clsViajeIncentivo
     * @return devuelve una cadena sobre la descripción de este viaje
     */
    @Override
    public String cualquierMetodo2()
    {
        return "Método implementado en la clase hija viaje de incentivo";
    }
}
