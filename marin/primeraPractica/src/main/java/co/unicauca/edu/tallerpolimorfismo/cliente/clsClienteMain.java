
package co.unicauca.edu.tallerpolimorfismo.cliente;

import co.unicauca.edu.tallerpolimorfismo.modelo.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * clsClienteMain que inicia el programa principal 
 * @author David Marín
 */
public class clsClienteMain 
{
    /***
     * Arreglo polimórfico de viajes 
     */
    public static List<clsViaje> objVarViajes = new ArrayList();
    
    public static void main(String [] args)
    {
        leerViajes();
        mostrarViajes();
    }
    
    /**
     * Lee viajes en el arreglo polimórfico
     */
    public static void leerViajes()
    {
        try
        {
            /**
             * Objeto objViaje1 para declarar un objeto de la clase clsViajeFamiliar
             * Objeto objViaje2 para declarar un objeto de la clase clsViajeIncentivo
             * Objeto objViaje3 para declarar un objeto de la clase clsViajeIndividual
             * Objeto objViaje4 para declarar un objeto de la clase clsViajeTodoIncluido
             */
            clsViaje objViaje1;
            clsViaje objViaje2;
            clsViaje objViaje3;
            clsViaje objViaje4;
            
            objViaje1 = new clsViajeFamiliar("Popayán", "Bogotá", 1250000, new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("05/05/2019"), 5);
            objVarViajes.add(objViaje1);
            
            objViaje2 = new clsViajeIncentivo("Popayán", "Medellin", 2100000, new SimpleDateFormat("dd/MM/yyyy").parse("03/06/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2019"), "Emtel");
            objVarViajes.add(objViaje2);
            
            objViaje3 = new clsViajeIndividual("Popayán", "San Andres", 4250000, new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"));
            objVarViajes.add(objViaje3);
            
            objViaje4 = new clsViajeTodoIncluido("Popayán", "Cartagena", 7350000, new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"));
            objVarViajes.add(objViaje4);
        }catch(ParseException ex)  
        {
            Logger.getLogger(clsClienteMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Recorre e imprime datos del arreglo polimórfico
     */
    public static void mostrarViajes()
    {
        /**
         * En este caso todos los viajes ejecutan el método descripción() de forma diferente, que al ser este método
           abstracto en la clase padre, se les fuerza a las clases hijas a que implementen ese método
         */
        for(clsViaje viaje:objVarViajes)
        {
            System.out.println("Origen: " + viaje.getOrigen());
            System.out.println("Destino: " + viaje.getDestino());
            System.out.println("Fecha Salida: " + viaje.getFechaSalida());
            System.out.println("Fecha Llegada: " + viaje.getFechaLlegada());
            System.out.println("Costo: " + viaje.getCosto());
            System.out.println("Descripción: " + viaje.descripcion());
            System.out.println("Cualquier método: " + viaje.cualquierMetodo());
            System.out.println("Cualquier método2: " + viaje.cualquierMetodo2());
            System.out.println("");
        }
    }
}
