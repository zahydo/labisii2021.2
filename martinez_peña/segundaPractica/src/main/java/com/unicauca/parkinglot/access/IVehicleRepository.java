/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import java.util.ArrayList;

/**
 *
 * @author 57322
 */
public interface IVehicleRepository {

    public boolean save(Vehicle v);

    public ArrayList<Vehicle> list();
}
