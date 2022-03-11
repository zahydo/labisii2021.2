package co.unicauca.foodapp.domain;

import java.util.Stack;

/**
 * Invocador de comandos. Ejecuta y deshace los comandos
 *
 * @author Diego Collazos, Eliana Cerquera
 */
public class Invoker {

    /**
     * Comando a ser invocado
     */
    private Command cmd;

    /**
     * Pila de operaciones deshacer
     */
    private final Stack<Command> undoStack;

    /**
     * Constructor por defecto
     */
    public Invoker() {
        undoStack = new Stack<>();
    }

    /**
     * Setter del comando
     * @param cmd clase concreta del abstract Command
     */
    public void setCommand(Command cmd) {
        this.cmd = cmd;
    }

    /**
     * Getter del comando
     * @return
     */
    public Command getCommand() {
        return cmd;
    }

    /**
     * Ejecuta el comando, y guarda este comando en la pila
     * de deshacer si el comando lo permite
     */
    public void execute() {
        if (cmd.hasUndo) {
            undoStack.push(cmd);
        }
        cmd.execute();
    }

    /**
     * Retira el ultimo comando de la pila y le indica que deshaga el procedimiento
     */
    public void undo() {
        if (!undoStack.isEmpty()) {
            Command cmdAux = undoStack.pop();
            cmdAux.undo();
        }
    }

    /**
     * Permite conocer si hay acciones por deshacer
     * @return true si sí, false si no
     */
    public boolean hasCommandUndo() {
        return !undoStack.isEmpty();
    }
}
