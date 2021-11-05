package co.unicauca.edu.tallerpolimorfismo_v2.cliente;

import co.unicauca.edu.tallerpolimorfismo_v2.modelo.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Clase con el método principal que ejecuta el programa
 * @author David Marín
 */
public class clsClienteMain 
{
    /**
     * Arreglo de viajes
     */
    public static List <clsViaje> objVarViajes = new ArrayList();
            
    public static void main(String[] args)
    {
        leerViajes();
        mostrarViajes();
    }
    
    /**
     * Lee viajes en al arreglo de viajes
     */
    public static void leerViajes()
    {
        try
        {
            clsViaje objViaje1;
            clsViaje objViaje2;
            clsViaje objViaje3;
            clsViaje objViaje4;
            
            objViaje1 = new clsViajeFamiliar("Popayán", "Bogotá", 1250000, new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("05/05/2019"), 5);
            objVarViajes.add(objViaje1);
            
            objViaje2 = new clsViajeIncentivo("Popayán", "Medellín", 2100000, new SimpleDateFormat("dd/MM/yyyy").parse("03/06/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2019"), "Emtel");
            objVarViajes.add(objViaje2);
            
            objViaje3 = new clsViajeIndividual("Popayán", "San Andres", 4250000, new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"));
            objVarViajes.add(objViaje3);
            
            objViaje4 = new clsViajeTodoIncluido("Popayán", "Cartagena", 7350000, new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"));
            objVarViajes.add(objViaje4);
        }
        catch(ParseException ex)
        {
            Logger.getLogger(clsClienteMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Muestra los viajes en el arreglo de viajes
     */
    public static void mostrarViajes()
    {
        /**
         * En este caso se ve que la descripción se comporta diferente forma.
         */
        for(clsViaje objVarViaje:objVarViajes)
        {
            System.out.println("Origen: " + objVarViaje.getDestino());
            System.out.println("Destino: " + objVarViaje.getDestino());
            System.out.println("Fecha salida: " + objVarViaje.getFechaSalida());
            System.out.println("Fecha llegada: " + objVarViaje.getFechaLlegada());
            System.out.println("Costo: " + objVarViaje.getCosto());
            System.out.println("Descripción: " + objVarViaje.descripcion());
            System.out.println("Cualquier método: " + objVarViaje.cualquierMetodo());
            System.out.println("Cualquier método2: " + objVarViaje.cualquierMetodo2());
            System.out.println("");
        }
    }
}
