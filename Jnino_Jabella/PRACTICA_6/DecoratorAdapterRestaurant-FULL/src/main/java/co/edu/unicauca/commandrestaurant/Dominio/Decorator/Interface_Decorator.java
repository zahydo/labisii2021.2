/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicauca.commandrestaurant.Dominio.Decorator;
import co.edu.unicauca.commandrestaurant.Dominio.Tipo_ComidaEnum;


/**
 *
 * @author J
 */
public interface Interface_Decorator {

    /**
     *
     * @return Id del plato
     */
    int getId();

    String getNombre();

    Tipo_ComidaEnum getTipo();

    void setId(int id);

    void setNombre(String name);

    void setTipo(Tipo_ComidaEnum type);

    @Override
    String toString();
    
}
