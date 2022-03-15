package co.mycompany.restaurant.client.presentation;

import co.mycompany.restaurant.client.access.IRestaurantAccess;
import co.mycompany.restaurant.client.access.RestauranteAccessImplSockets;
import co.mycompany.restaurant.commons.domain.Plato;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author linux
 */
public class MainTest {

    /**
     * test para agregar plato en el cliente
     * @throws Exception 
     */
    @Test
    public void testCrearPlato() throws Exception {
        IRestaurantAccess test = new RestauranteAccessImplSockets();
        Plato newPlate = new Plato("3", "Arroz Chino", "18000", "30 g de res");
        String response = test.AgregarPlato(newPlate);
        assertEquals(response, "Arroz Chino");
        newPlate = new Plato("4", "Bisteck de Carne", "13000", "200 g de res");
        response = test.AgregarPlato(newPlate);
        assertEquals(response, "Bisteck de Carne");
        newPlate = new Plato("5", "carne asada", "2000", "200 g de res");
        response = test.AgregarPlato(newPlate);
        assertEquals(response, "carne asada");
        newPlate = new Plato("6", "carne de cerdo asada", "10000", "200 g de cerdo");
        response = test.AgregarPlato(newPlate);
        assertEquals(response, "carne de cerdo asada");

    }

}
