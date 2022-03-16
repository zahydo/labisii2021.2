package co.edu.unicauca.cor.domain;

import java.time.LocalDate;

/**
 * Reclamo del cliente por pedido insatisfecho
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class Reclamo {

    private int atrID;
    private String atrTitulo;
    private String atrDescripcion;
    private TipoEnum atrTipo;
    private LocalDate atrFecha;
    private boolean atrAttended;

    public Reclamo(int prmID, String prmTitulo, String prmDescripcion, TipoEnum prmTipo) {
        this.atrID = prmID;
        this.atrTitulo = prmTitulo;
        this.atrDescripcion = prmDescripcion;
        this.atrTipo = prmTipo;
        this.atrAttended = false;
        this.atrFecha = LocalDate.now();
    }

    public int getAtrID() {
        return atrID;
    }

    public void setAtrID(int atrID) {
        this.atrID = atrID;
    }

    public String getAtrTitulo() {
        return atrTitulo;
    }

    public void setAtrTitulo(String atrTitulo) {
        this.atrTitulo = atrTitulo;
    }

    public String getAtrDescripcion() {
        return atrDescripcion;
    }

    public void setAtrDescripcion(String atrDescripcion) {
        this.atrDescripcion = atrDescripcion;
    }

    public TipoEnum getAtrTipo() {
        return atrTipo;
    }

    public void setAtrTipo(TipoEnum atrTipo) {
        this.atrTipo = atrTipo;
    }

    public boolean isAtrAttended() {
        return atrAttended;
    }

    public void setAtrAttended(boolean atrAttended) {
        this.atrAttended = atrAttended;
    }

    public LocalDate getAtrFecha() {
        return atrFecha;
    }

}
