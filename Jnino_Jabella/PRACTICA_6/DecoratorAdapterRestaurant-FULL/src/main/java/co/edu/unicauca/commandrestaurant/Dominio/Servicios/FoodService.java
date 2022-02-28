package co.edu.unicauca.commandrestaurant.Dominio.Servicios;

import java.util.List;
import co.edu.unicauca.commandrestaurant.Dominio.Comida;
import co.edu.unicauca.commandrestaurant.Acceso.Interface_ComidaRepository;

/**
 * Fachada de los servicios de comida. Es el receptor, al cual se le ejecutan
 * sus operaciones mediante comandos
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class FoodService {
    /**
     * Dependencia abstracta al repositorio
     */
    private Interface_ComidaRepository repo;

    /**
     * Construcor parametrizado
     *
     * @param repo repositorio que es inyectado
     */
    public FoodService(Interface_ComidaRepository repo) {
        this.repo = repo;

    }

    /**
     * Crear una comida
     *
     * @param food comdia a crearse en la bd
     */
    public void create(Comida food) {
        repo.NuevaComida(food);
    }

    /**
     * Modifica una comida
     *
     * @param food comida a ser grabada en la bd
     */
    public void update(Comida food) {
        repo.ModificarComida(food);
    }

    /**
     * Eliminar comida
     *
     * @param id identificador de la comida
     */
    public void delete(int id) {
        repo.EliminarComida(id);
    }

    /**
     * Buscar todas las comidas
     *
     * @return lista de comidas
     */
    public List<Comida> findAll() {
        return repo.ObtenerTodasLasComidas();
    }

    /**
     * Buscar comida por su id
     *
     * @param id identificador de la comida
     * @return Comida
     */
    public Comida findByIdl(int id) {
        return repo.EncontrarPorID(id);
    }

}
