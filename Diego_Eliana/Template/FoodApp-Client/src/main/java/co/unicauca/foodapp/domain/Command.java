package co.unicauca.foodapp.domain;

/**
 * Clase abstracta que representa un Comando cualquiera
 *
 * @author Diego Collazos, Eliana Cerquera
 */
public abstract class Command {

    /**
     * Indicador de si esta disponible el deshacer
     */
    protected boolean hasUndo;
    
    /**
     * Metodo abstracto para ejecutar el comando
     */
    public abstract void execute();

    /**
     * Metodo abstracto para deshacer el comando
     */
    public abstract void undo();
    
    /**
     * Getter de hasUndo
     * @return
     */
    public boolean hasUndo() {
        return hasUndo;
    }
    /**
     * Setter de hasUndo
     * @param hasUndo nuevo valor
     */
    public void setHasUndo(boolean hasUndo) {
        this.hasUndo = hasUndo;
    }
}
