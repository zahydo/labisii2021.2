package co.edu.unicauca.commandrestaurant.Dominio.Decorator;

import co.edu.unicauca.commandrestaurant.Dominio.Comida;
import co.edu.unicauca.commandrestaurant.Dominio.Tipo_ComidaEnum;
import co.edu.unicauca.commandrestaurant.Infra.Utilidades;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class CapitalFood extends Comida implements Interface_Decorator {
    /**
     * Comida decorada
     */
    private Comida atrDecoratedComida;

    /**
     * Costructor
     * @param id es el identificador
     * @param name es el nombre del plato
     * @param type es el tipo de plato
     */
    public CapitalFood(int id, String name, Tipo_ComidaEnum type) {
        //Lo convierte a mayúsculas
        String capitalizeFoodName = Utilidades.capitalize(name);
        atrDecoratedComida = new CryptFood(id, capitalizeFoodName, type);
    }

    @Override
    public void setNombre(String name) {
        atrDecoratedComida.setNombre(name.toUpperCase());
    }

    @Override
    public String getNombre() {
        return atrDecoratedComida.getNombre();
    }

    /**
     *
     * @return Id del plato
     */
    @Override
    public int getId() {
        return atrDecoratedComida.getId();
    }

    @Override
    public void setId(int id) {
        atrDecoratedComida.setId(id);
    }

    @Override
    public Tipo_ComidaEnum getTipo() {
        return atrDecoratedComida.getTipo();
    }

    @Override
    public void setTipo(Tipo_ComidaEnum type) {
        atrDecoratedComida.setTipo(type);
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + atrDecoratedComida.getId() + ", name=" + atrDecoratedComida.getNombre() + ", type=" + atrDecoratedComida.getTipo() + '}';
    }

}
