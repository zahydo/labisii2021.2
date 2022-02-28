/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.commandrestaurant.Acceso.Adapter;

import co.edu.unicauca.commandrestaurant.Dominio.Comida;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author J
 */
public class FoodJsonArrayRepository {

    private static ArrayList<String> ListaComidaJson;
    private final Gson gson;

    public FoodJsonArrayRepository() {
        this.gson = new Gson();
        if (ListaComidaJson == null) {
            ListaComidaJson = new ArrayList<>();
        }

    }

    public boolean ModificarComida(Comida prmComida) {
        Comida objComida = this.ObtenerPorID(prmComida.getId());
        if (objComida != null) {
            EliminarComida(objComida.getId());
            AgregarComida(prmComida);
            return true;
        }
        return false;
    }

   
    public boolean EliminarComida(int prmId) {
        for (String item : ListaComidaJson) {
            if (item.contains("\"id\":" + prmId)) {
                ListaComidaJson.remove(item);
                return true;
            }
        }
        return false;
    }

    
    public ArrayList<String> ObtenerTodasLasComidas() {
        return ListaComidaJson;
    }
    
    public Comida ObtenerPorID(int prmId) {
        for (String item : ListaComidaJson) {
            if (item.contains("\"id\":" + prmId)) {
                return gson.fromJson(item, Comida.class);
            }
        }
        return null;
    }

    public boolean AgregarComida(Comida prmComida) {
        if (ObtenerPorID(prmComida.getId()) == null) {
            ListaComidaJson.add(gson.toJson(prmComida));
            return true;
        }
        return false;
    }
}
