/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.parkinglot.access;

/**
 *
 * @author 57322
 */
public class RepositoryFactory {

    //Atributos
    // Singleton
    private static RepositoryFactory instance;

    //Constructor
    private RepositoryFactory() {

    }

    /**
     * Devuelve la instancia de la clase
     *
     * @return instancia unica de la la RepositoryFactory
     */
    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }

    public IVehicleRepository getRepository(String type) {
        return new VehicleRepository();

    }

}
