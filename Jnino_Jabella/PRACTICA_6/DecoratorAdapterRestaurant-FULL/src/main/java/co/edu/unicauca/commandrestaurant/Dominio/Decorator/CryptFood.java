/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.commandrestaurant.Dominio.Decorator;

import co.edu.unicauca.commandrestaurant.Dominio.Comida;
import co.edu.unicauca.commandrestaurant.Dominio.Tipo_ComidaEnum;
import co.edu.unicauca.commandrestaurant.Infra.Utilidades;

/**
 * @author J
 */
public class CryptFood extends Comida implements Interface_Decorator {

    private Comida atrComidaEncriptada;

    public CryptFood(int prmId, String prmNombre, Tipo_ComidaEnum prmTipo) {

        String Cryptname = Utilidades.encriptar(prmNombre);
        atrComidaEncriptada = new Comida(prmId, Cryptname, prmTipo);

    }

    @Override
    public void setNombre(String prmNombre) {

        atrComidaEncriptada.setNombre(Utilidades.encriptar(prmNombre));

    }

    @Override
    public String getNombre() {
        //return Utilidades.desencriptar(myCryptFood.getNombre());
        return atrComidaEncriptada.getNombre();
    }

    /**
     *
     * @retorna el Id de la comida
     */
    @Override
    public int getId() {
        return atrComidaEncriptada.getId();
    }

    @Override
    public void setId(int prmId) {
        atrComidaEncriptada.setId(prmId);
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + atrComidaEncriptada.getId() + ", name=" + atrComidaEncriptada.getNombre() + ", type=" + atrComidaEncriptada.getTipo() + '}';
    }

    @Override
    public Tipo_ComidaEnum getTipo() {
        return atrComidaEncriptada.getTipo();
    }

    @Override
    public void setTipo(Tipo_ComidaEnum prmTipo) {
        atrComidaEncriptada.setTipo(prmTipo);
    }

}
