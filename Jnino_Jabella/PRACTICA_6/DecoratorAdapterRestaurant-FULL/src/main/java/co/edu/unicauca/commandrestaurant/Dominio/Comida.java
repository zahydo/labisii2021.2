package co.edu.unicauca.commandrestaurant.Dominio;

/**
 * Representa una comida del restaurante de cualquier tipo: Entrada, principio,
 * carne, postre
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class Comida {

    private int id;
    private String name;
    private Tipo_ComidaEnum type;

    public Comida(){
    }
    
    public Comida(int id, String name, Tipo_ComidaEnum type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public Tipo_ComidaEnum getTipo() {
        return type;
    }

    public void setTipo(Tipo_ComidaEnum type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + id + ", name=" + name + ", type=" + type + '}';
    }
}
