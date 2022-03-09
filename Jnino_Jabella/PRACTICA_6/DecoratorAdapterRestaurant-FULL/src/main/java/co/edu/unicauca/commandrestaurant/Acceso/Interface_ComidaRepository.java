package co.edu.unicauca.commandrestaurant.Acceso;

import java.util.List;
import co.edu.unicauca.commandrestaurant.Dominio.Comida;

/**
 * Interface que define los servicios de persistencia de comidas
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public interface Interface_ComidaRepository {

    /**
     * Buscar una comida
     *
     * @param id identificador
     * @return objeto comida
     */
    public Comida EncontrarPorID(int id);

    /**
     * Busca todas las comidas
     *
     * @return lista de comidas
     */
    public List<Comida> ObtenerTodasLasComidas();

    /**
     *
     * @param food comida a agregar
     * @return true si la agrega, false en caso contrario
     */
    public boolean NuevaComida(Comida food);

    /**
     * Modifica una comida
     *
     * @param food comida a ser modificada
     * @return true si lo modifica con exito, false en caso contrario
     */
    public boolean ModificarComida(Comida food);

    /**
     * Eliminar una comida
     *
     * @param id identificador de la comida
     */
    public void EliminarComida(int id);

}
