package co.unicauca.parkinglot.domain;

/**
 *
 * @author jnino_jabella
 */
public class Vehicle {

    private String placa;
    private TypeEnum tipo;

    public Vehicle(String placa, TypeEnum tipo) {
        this.placa = placa;
        this.tipo = tipo;
    }

    public Vehicle() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TypeEnum getTipo() {
        return tipo;
    }

    public void setTipo(TypeEnum tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "placa =" + placa + ", tipo =" + tipo + '}';
    }

}
