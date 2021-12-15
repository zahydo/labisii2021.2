/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.access;

/**
 * Fabrica que permite crear nuevos repositorios de vehiculos
 * @author Jose_R
 */
public class RepositoryFactory {
    //Intancia de la fabrica
    private static RepositoryFactory instance;
    /**
     * Metodo constructo de la fabrica
     */
    private RepositoryFactory() {
    }

    /**
     * Clase singleton
     * Creas nuevas instancias de la fabrica
     * @return la instancia de la fabrica
     */
    public static RepositoryFactory getInstance() {

        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;

    }
    /**
     * Cra el nuevo repositorio de vehiculos segun su tipo
     * @param type tipo de vehiculo
     * @return el repositorio de vehiculos creado
     */
    public IVehicleRepository getRepository(String type) {

        IVehicleRepository result = null;

        switch (type) {
            case "default":
                result = new VehicleRepository();
                break;
        }

        return result;

    }
}
