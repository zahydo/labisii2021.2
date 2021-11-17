/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import java.util.ArrayList;

/**
 * Interfaz de Repositorios
 * @fecha 2021/11/17
 * @author Miguel Mosquera, Sebastian Arenas
 */
public interface IVehicleRepository {
    
    /** 
     * Guarda un vehiculo 
     * @param Vehiculo
     * @return True si guardo con exito 
     */
    public boolean save(Vehicle vehiculo);
    
    /** 
     * Obtener lista de la Base de Datos 
     * @return Lista de vehiculos dentro de la base de datos
     */
    public ArrayList<Vehicle> list();
}
