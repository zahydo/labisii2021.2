package co.mycompany.restaurant.server.access;

import co.mycompany.restaurant.commons.domain.Plato;

/**
 * @author Fabián David Marín - Hector Fernando Dorado - Juan Sebastian Sanchez
 * 
 * Interface de reposotorio del plato
 */
public interface IPlatoRepository {
    /**
     * Crea un Plato
     * @param plato
     * @return  nombre del plato
     */
    public String crearPlato(Plato plato);

}
