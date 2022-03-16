package co.edu.unicauca.cor.domain;

/**
 * Manejador de reclamos
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public abstract class Manejador_Reclamos {

    private Manejador_Reclamos atrSiguienteManipulador;
    private String atrEmail;

    public Manejador_Reclamos(String email) {
        this.atrEmail = email;
    }

    public String getAtrEmail() {
        return atrEmail;
    }

    public abstract boolean attend(Reclamo request);

    public Manejador_Reclamos getAtrSiguienteManipulador() {
        return atrSiguienteManipulador;
    }

    public void setAtrSiguienteManipulador(Manejador_Reclamos handler) {
        atrSiguienteManipulador = handler;
    }
}
