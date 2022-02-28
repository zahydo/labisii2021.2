/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.commandrestaurant.Acceso.Adapter;

import co.edu.unicauca.commandrestaurant.Dominio.Comida;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import co.edu.unicauca.commandrestaurant.Acceso.Interface_ComidaRepository;

/**
 *
 * @author J
 */
public class FoodRepositoryJsonArrayAdapter implements Interface_ComidaRepository {

    FoodJsonArrayRepository Repositorio;
    
    public FoodRepositoryJsonArrayAdapter() {
        Repositorio = new FoodJsonArrayRepository();
    }
    
    
    @Override
    public Comida EncontrarPorID(int prmId) {
        return Repositorio.ObtenerPorID(prmId);
    }

    @Override
    public List<Comida> ObtenerTodasLasComidas() {
        Gson gson = new Gson();
        List<Comida> foods = new ArrayList<>();
        Repositorio.ObtenerTodasLasComidas().forEach(token -> { 
            foods.add(gson.fromJson(token, Comida.class));
        });
        return foods;
    }
   
    @Override
    public boolean ModificarComida(Comida prmComida) {
        Comida objComidaModificada = new Comida(prmComida.getId(),prmComida.getNombre(), prmComida.getTipo());
        return Repositorio.ModificarComida(objComidaModificada);
    }

    /*
    @parametro prmId, id de la comida a eliminar
    */
    @Override
    public void EliminarComida(int prmId) {
        Repositorio.EliminarComida(prmId);
    }
    
     @Override
    public boolean NuevaComida(Comida prmComida) {
        Comida objComidaNueva = new Comida(prmComida.getId(),prmComida.getNombre(), prmComida.getTipo());
        return Repositorio.AgregarComida(objComidaNueva);
    }
}
