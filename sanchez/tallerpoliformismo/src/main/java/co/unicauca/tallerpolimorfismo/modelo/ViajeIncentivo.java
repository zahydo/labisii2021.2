package co.unicauca.tallerpolimorfismo.modelo;

import java.util.Date;

/**
 *
 * @author Sebastian
 */
public class ViajeIncentivo extends Viaje {

    /**
     * Empresa que patrocina el viaje al empleado
     */
    private String empresa;
//Constructor, getters and setters

    public ViajeIncentivo(String origen, String destino, int costo, Date fechaSAlida, Date fachaLlegada, String empresa) {
        super(origen, destino, costo, fechaSAlida, fachaLlegada);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String descripcion() {
        return "Viaje incentivo que te envia la empresa " + empresa;
    }

    public String cualquierMetodo2() {
        return "Método implementado en la clase hija viaje de incentivo";
    }
}
