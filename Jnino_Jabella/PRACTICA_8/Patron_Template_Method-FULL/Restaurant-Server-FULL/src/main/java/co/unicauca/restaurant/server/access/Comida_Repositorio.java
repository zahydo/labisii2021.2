/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.domain.Food;
import co.unicauca.restaurant.commons.domain.FoodTypeEnum;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Libardo, Julio
 */
public class Comida_Repositorio implements Interface_Repositorio_Comida {

    private static List<Food> atrListaComida;

    /*
       Constructor
     */
    public Comida_Repositorio() {
        if (atrListaComida == null) {
            atrListaComida = new ArrayList<>();
            initData();
        }
    }

    /*
      Metodo que inicializa por defecto 3 comidas para hacer el test.
     */
    private void initData() {
        atrListaComida.add(new Food(1, "sopa de iguana", FoodTypeEnum.ENTRADA));
        atrListaComida.add(new Food(2, "Salchipapa sin salchicha", FoodTypeEnum.PRINCIPIO));
        atrListaComida.add(new Food(3, "Jugo de zapallo en leche", FoodTypeEnum.JUGO));
        atrListaComida.add(new Food(4, "Pan sin harina", FoodTypeEnum.POSTRE));
    }

    /*
    Metodo que encuentra una comida por el prmID
    @param recibe como parametro la prmID de la comida a buscar
    @return objeto de tipo Food si se encontro, de caso contrario retorna null.
    
     */
    @Override
    public Food EncontrarPorID(int prmID) {
        for (Food comp : atrListaComida) {
            if (comp.getIdFood() == prmID) {
                return comp;
            }
        }
        return null;
    }

    /*
        Metodo que añade una comida al menu
        @param component de tipo food que se le añadira a la lista de comidas
     */
    @Override
    public boolean Crear(Food component) {
        System.out.println("Se añadidio la comida :" + component.toString());
        atrListaComida.add(component);
        return true;
    }

    @Override
    public boolean Actualizar(Food component) {
        for (Food componentAux : atrListaComida) {
            if (componentAux.getIdFood() == component.getIdFood()) {
                //Modificamos sus datos
                componentAux.setNameFood(component.getNameFood());
                componentAux.setType(component.getType());
                return true;
            }
        }
        return false;

    }

    /*
    Metodo que busca por id una comida y la elimina
    @param recibe como parametro el id de la comida a eliminar
    @return true or false dependiendo si se hizo la operacion.
    
     */
    @Override
    public boolean Eliminar(int id) {
        int i = 0;
        for (Food componentAux : atrListaComida) {
            if (componentAux.getIdFood() == id) {
                atrListaComida.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }

    /**
     * Metodo que obtiene la lista de comidas.
     *
     * @return lista de clientes
     */
    @Override
    public List<Food> ListaComidas() {
        return atrListaComida;
    }
}
