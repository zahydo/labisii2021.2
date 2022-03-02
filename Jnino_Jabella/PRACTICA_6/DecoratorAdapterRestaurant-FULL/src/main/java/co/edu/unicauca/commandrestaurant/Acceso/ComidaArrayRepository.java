package co.edu.unicauca.commandrestaurant.Acceso;

import co.edu.unicauca.commandrestaurant.Dominio.Comida;
import co.edu.unicauca.commandrestaurant.Dominio.Decorator.CapitalFood;
import co.edu.unicauca.commandrestaurant.Dominio.Tipo_ComidaEnum;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del repositorio con arreglos
 *
 * @author Libardo, Julio
 */
public class ComidaArrayRepository implements Interface_ComidaRepository {

    private static List<Comida> Componentes;

    public ComidaArrayRepository() {
        if (Componentes == null) {
            Componentes = new ArrayList<>();
            initData();
        }
    }
    
    @Override
    public Comida EncontrarPorID(int id) {
        for (Comida comp : Componentes) {
            if (comp.getId() == id) {
                return comp;
            }
        }
        return null;
    }

    @Override
    public boolean NuevaComida(Comida componente) {
        Componentes.add(componente);
        return true;
    }

    @Override
    public boolean ModificarComida(Comida componente) {
        for (Comida componenteAux : Componentes) {
            if (componenteAux.getId() == componente.getId()) {
                componenteAux.setNombre(componente.getNombre());
                componenteAux.setTipo(componente.getTipo());
                return true;
            }
        }
        return false;

    }

    @Override
    public void EliminarComida(int id) {
        int i = 0;
        for (Comida componenteAux : Componentes) {
            if (componenteAux.getId() == id) {
                Componentes.remove(i);
                return;
            }
            i++;
        }
    }

    private void initData() {
        Componentes.add(new CapitalFood(1, "Fríjoles negros", Tipo_ComidaEnum.PRINCIPIO));
        Componentes.add(new CapitalFood(2, "Sopa de verduras sin zanahoria", Tipo_ComidaEnum.ENTRADA));
        Componentes.add(new CapitalFood(3, "Jugo de mango en leche", Tipo_ComidaEnum.JUGO));
    }

    
    /**
     * Busca los n primeros registros de clientes
     *
     * @return lista de clientes
     */
    @Override
    public List<Comida> ObtenerTodasLasComidas() {
        return Componentes;
    }

}
