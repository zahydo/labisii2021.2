
package co.unicauca.edu.tallerpolimorfismo.test;

import co.unicauca.edu.tallerpolimorfismo.modelo.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David Marín
 */
public class clsViajeTest 
{
    
    public clsViajeTest() {}
    
    /**
     * Test de la clase clsViajeFamiliar
     * @throws java.text.ParseException
     */
    @Test
    public void testClsViajeFamiliar() throws ParseException
    {
        System.out.println("Viaje Familiar");
        clsViajeFamiliar objViaje;
        objViaje = new clsViajeFamiliar("Popayán", "Bogotá", 1250000, new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("05/05/2019"), 5);
        assertEquals("Popayán", objViaje.getOrigen());
        assertEquals("Bogotá", objViaje.getDestino());
        assertEquals(1250000, objViaje.getCosto());
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"), objViaje.getFechaSalida());
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("05/05/2019"), objViaje.getFechaLlegada());
        assertEquals(5, objViaje.getFamilia());
        assertEquals("Viaje para disfrutar con toda tu familia", objViaje.descripcion());
        assertEquals("Cualquier método implementado en la clase base", objViaje.cualquierMetodo());
        assertEquals("Método implementado en la clase hija viaje familiar", objViaje.cualquierMetodo2());
    }
    
    /**
     * Test de la clase clsViajeIncentivo
     * @throws java.text.ParseException
     */ 
    @Test
    public void testClsViajeIncentivo() throws ParseException
    {
        System.out.println("Viaje Incentivo");
        clsViajeIncentivo objViaje;
        objViaje = new clsViajeIncentivo("Popayán", "Medellin", 2100000, new SimpleDateFormat("dd/MM/yyyy").parse("03/06/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2019"), "Emtel");
        assertEquals("Popayán", objViaje.getOrigen());
        assertEquals("Medellin", objViaje.getDestino());
        assertEquals(2100000, objViaje.getCosto());
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("03/06/2019"), objViaje.getFechaSalida());
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2019"), objViaje.getFechaLlegada());
        assertEquals("Emtel", objViaje.getEmpresa());
        assertEquals("Viaje incentivo que te envia la empresa Emtel", objViaje.descripcion());
        assertEquals("Cualquier método implementado en la clase base", objViaje.cualquierMetodo());
        assertEquals("Método implementado en la clase hija viaje de incentivo", objViaje.cualquierMetodo2());
    }
    
    /**
     * Test de la clase clsViajeIndivifual
     * @throws java.text.ParseException
     */
    @Test
    public void testClsViajeIndividual() throws ParseException
    {
        System.out.println("Viaje Individual");
        clsViaje objViaje;
        objViaje = new clsViajeIndividual("Popayán", "San Andres", 4250000, new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"));
        assertEquals("Popayán", objViaje.getOrigen());
        assertEquals("San Andres", objViaje.getDestino());
        assertEquals(4250000, objViaje.getCosto());
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), objViaje.getFechaSalida());
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"), objViaje.getFechaLlegada()); 
        assertEquals("Disfruta tu viaje individual", objViaje.descripcion());
        assertEquals("Cualquier método implementado en la clase base", objViaje.cualquierMetodo());
        assertEquals("Cualquier método2 implementado en la clase base", objViaje.cualquierMetodo2());
    }
    
    /**
     * Test de la clase clsViajeTodoIncluido
     * @throws java.text.ParseException
     */
    @Test
    public void testClsViajeTodoIncluido() throws ParseException
    {
        System.out.println("Viaje Todo Incluido");
        clsViaje objViaje;
        objViaje = new clsViajeTodoIncluido("Popayán", "Cartagena", 7350000, new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"));
        assertEquals("Popayán", objViaje.getOrigen());
        assertEquals("Cartagena", objViaje.getDestino());
        assertEquals(7350000, objViaje.getCosto());
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), objViaje.getFechaSalida());
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"), objViaje.getFechaLlegada());
        assertEquals("Disfruta tu viaje todo incluido", objViaje.descripcion());
        assertEquals("Cualquier método implementado en la clase base", objViaje.cualquierMetodo());
        assertEquals("Cualquier método2 implementado en la clase base", objViaje.cualquierMetodo2());
    }
}
