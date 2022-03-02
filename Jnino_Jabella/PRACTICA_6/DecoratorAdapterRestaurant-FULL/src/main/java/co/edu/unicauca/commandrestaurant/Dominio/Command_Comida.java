package co.edu.unicauca.commandrestaurant.Dominio;

import co.edu.unicauca.commandrestaurant.Acceso.RepositoryFactory;
import co.edu.unicauca.commandrestaurant.Dominio.Servicios.FoodService;
import co.edu.unicauca.commandrestaurant.Acceso.Interface_ComidaRepository;

/**
 * Clase abstracta que representa un Comando cualquieraF
 *
 * @author Libardo, Julio
 */
public abstract class Command_Comida {
      protected Interface_ComidaRepository repo;
      protected FoodService service;
      protected boolean hasUndo;
    /**
     * ¿Tiene deshacer?
     *
     */
    
    public Command_Comida(){
         repo = RepositoryFactory.getInstance().getRepository();
         service = new FoodService(repo);
    }
    
    /**
     * Ejecuta el comando
     */
    public abstract void execute();

    /**
     * Dehace el comando
     */
    public abstract void undo();

    public boolean hasUndo() {
        return hasUndo;
    }

    public void setHasUndo(boolean hasUndo) {
        this.hasUndo = hasUndo;
    }

}
