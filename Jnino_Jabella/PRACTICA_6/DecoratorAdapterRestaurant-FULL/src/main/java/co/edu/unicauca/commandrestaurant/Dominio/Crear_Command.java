package co.edu.unicauca.commandrestaurant.Dominio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Comando concreto para crear una comida
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class Crear_Command extends Command_Comida {

    /**
     * Comida a crear
     */
    private Comida Comida;

    /**
     * Constructor parametrizado
     *
     * @param food comida crear en la base de datos
     */
    public Crear_Command(Comida Comida) {
        super();
        this.Comida = Comida;
        this.hasUndo = true;
    }

    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(Crear_Command.class); 
        logger.info("Comando de creación ejecutado. Se creo la comida " + Comida.toString());
        service.create(Comida);
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(Crear_Command.class); 
        logger.info("Comando de creación deshecho. Se eliminó la comida " + Comida.toString());        
        service.delete(Comida.getId());
    }

}
