package co.unicauca.tallerpolimorfismo.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Libardo Pantoja, Santiago Hyun
 */
public class ViajeTest {

    public ViajeTest() {
    }

    /**
     * Test de la clase ViajeFamiliar.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testViajeFamiliar() throws ParseException {
        System.out.println("Viaje familiar");
        ViajeFamiliar viaje = new ViajeFamiliar("Popay�n", "Bogot�", 1250000, new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("05/05/2019"), 5);
        assertEquals("Popay�n", viaje.getOrigen());
        assertEquals("Bogot�", viaje.getDestino());
        assertEquals(1250000, viaje.getCosto());
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"), viaje.getFechaSalida());
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("05/05/2019"), viaje.getFechaLlegada());
        assertEquals(5, viaje.getFamilia());
        assertEquals("Viaje para disfrutar con toda tu familia", viaje.descripcion());
        assertEquals("Cualquier m�todo implementado en la clase base", viaje.cualquierMetodo());
        assertEquals("M�todo implementado en la clase hija viaje familiar", viaje.cualquierMetodo2());
    }

    /**
     * Test de la clase ViajeIncentivo.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testViajeIncentivo() throws ParseException {
        System.out.println("Viaje incentivo");
        ViajeIncentivo viaje = new ViajeIncentivo("Popay�n", "Medellin", 2100000, new SimpleDateFormat("dd/MM/yyyy").parse("03/06/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2019"), "Emtel");
        assertEquals("Popay�n", viaje.getOrigen());
        assertEquals("Medellin", viaje.getDestino());
        assertEquals(2100000, viaje.getCosto());
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("03/06/2019"), viaje.getFechaSalida());
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2019"), viaje.getFechaLlegada());
        assertEquals("Emtel", viaje.getEmpresa());
        assertEquals("Viaje incentivo que te envia la empresa Emtel", viaje.descripcion());
        assertEquals("Cualquier m�todo implementado en la clase base", viaje.cualquierMetodo());
        assertEquals("M�todo implementado en la clase hija viaje de incentivo", viaje.cualquierMetodo2());
    }

    /**
     * Test de la clase ViajeIndividual.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testViajeIndividual() throws ParseException {
        System.out.println("Viaje individual");
        Viaje viaje = new ViajeIndividual("Popay�n", "San Andres", 4250000, new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"));
        assertEquals("Popay�n", viaje.getOrigen());
        assertEquals("San Andres", viaje.getDestino());
        assertEquals(4250000, viaje.getCosto());
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), viaje.getFechaSalida());
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"), viaje.getFechaLlegada());
        assertEquals("Disfruta tu viaje individual", viaje.descripcion());
        assertEquals("Cualquier m�todo implementado en la clase base", viaje.cualquierMetodo());
        assertEquals("Cualquier m�todo2 implementado en la clase base", viaje.cualquierMetodo2());

    }

    /**
     * Test de la clase ViajeTodoIncluido.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testViajeTodoIncluido() throws ParseException {
        System.out.println("Viaje todo incluido");
        Viaje viaje = new ViajeTodoIncluido("Popay�n", "Cartagena", 7350000, new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"));
        assertEquals("Popay�n", viaje.getOrigen());
        assertEquals("Cartagena", viaje.getDestino());
        assertEquals(7350000, viaje.getCosto());
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), viaje.getFechaSalida());
        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"), viaje.getFechaLlegada());
        assertEquals("Disfruta tu viaje todo incluido", viaje.descripcion());
        assertEquals("Cualquier m�todo implementado en la clase base", viaje.cualquierMetodo());
        assertEquals("Cualquier m�todo2 implementado en la clase base", viaje.cualquierMetodo2());
    }

}