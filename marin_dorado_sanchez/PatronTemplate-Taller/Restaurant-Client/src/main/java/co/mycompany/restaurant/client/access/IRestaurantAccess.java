package co.mycompany.restaurant.client.access;

import co.mycompany.restaurant.commons.domain.Plato;

/**
 *
 * @author Fabián David Marín - Hector Fernando Dorado - Juan Sebastian Sanchez
 */
public interface IRestaurantAccess {
    
    /**
     * Método que crea un Plato
     *
     * @param plato plato 
     * @return retorna una cadena del plato
     * @throws Exception error 
     */
    public String AgregarPlato(Plato plato)throws Exception;
}
