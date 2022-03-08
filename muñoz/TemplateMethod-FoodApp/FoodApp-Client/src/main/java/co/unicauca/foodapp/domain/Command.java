package co.unicauca.foodapp.domain;

/**
 * Clase abstracta que representa un Comando cualquieraF
 *
 * @author libardo
 */
public abstract class Command {

    /**
     * ¿Tiene deshacer?
     *
     */
    protected boolean hasUndo;

    /**
     * Ejecuta el comando
     */
    public abstract void execute();

    /**
     * Dehace el comando
     */
    public abstract void undo();

    /**
     * tiene un proceso de reversión 
     * @return
     */
    public boolean hasUndo() {
        return hasUndo;
    }

    /**
     * cambia si tiene reversibilidad 
     * @param hasUndo
     */
    public void setHasUndo(boolean hasUndo) {
        this.hasUndo = hasUndo;
    }

}
