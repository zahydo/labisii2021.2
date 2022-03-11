package co.mycompany.restaurant.server.access;

import co.mycompany.restaurant.commons.domain.Plato;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fabián David Marín - Hector Fernando Dorado
 * 
 * Clase que implementa el IPlatoRepository
 */
public final class PlatoRepositoryImplArrays implements IPlatoRepository {

    /**
     * Array List de platos de tipo plato
     */
    private static List<Plato> platos;

    /**
     * Constructor
     */
    public PlatoRepositoryImplArrays() {
        if (platos == null){
            platos = new ArrayList();
        }
        if (platos.isEmpty()){
            inicializar();
        }
    }

    /**
     * inicializamos la lista con algunos platos
     */
    public void inicializar() {
        platos.add(new Plato("1","Arroz con pollo","15000","50 g de pollo"));
        platos.add(new Plato("2","Arroz con verdura","15000","30 g de verdura"));
    }
    
    /**
     * Clase extendida de la interface que crear un plato
     * @param plato a agregar
     * @return  nombre del plato
     */
    @Override
    public String crearPlato(Plato plato) {
        platos.add(plato);
        return plato.getPlatoNombre();
    }

}
