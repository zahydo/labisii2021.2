package co.edu.unicauca.commandrestaurant.Acceso.Adapter;

import co.edu.unicauca.commandrestaurant.Dominio.Comida;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import co.edu.unicauca.commandrestaurant.Acceso.Interface_ComidaRepository;

/**
 * Adaptador de FoodMapRepository. Implementa la misma interfaz IFoodRepository
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class FoodRepositoryMapAdapter implements Interface_ComidaRepository {

    /**
     * Repositorio adaptado
     */
    FoodMapRepository Repositorio;

    /**
     * Constructor
     */
    public FoodRepositoryMapAdapter() {
        Repositorio = new FoodMapRepository();
    }

    @Override
    public Comida EncontrarPorID(int prmId) {
        return Repositorio.getById(prmId);
    }

    @Override
    public List<Comida> ObtenerTodasLasComidas() {
        Map<Integer, Comida> map = Repositorio.getAll();
        List<Comida> list = new ArrayList(map.values());
        return list;
    }

    @Override
    public boolean ModificarComida(Comida prmComida) {
        return Repositorio.modify(prmComida);
    }

    @Override
    public void EliminarComida(int prmId) {
        Repositorio.remove(prmId);
    }
    
    @Override
    public boolean NuevaComida(Comida prmComida) {
        return Repositorio.add(prmComida);
    }

}
