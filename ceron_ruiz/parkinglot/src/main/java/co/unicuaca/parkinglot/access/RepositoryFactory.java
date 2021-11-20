/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicuaca.parkinglot.access;

/**
 * @author Daniel Cerón
 */
public class RepositoryFactory {

    private static RepositoryFactory instance;

    private RepositoryFactory() {
    }

    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }

    /**
     * Create an instance of the children class
     */
    public IVehicleRepository getRepository(String type) {

        IVehicleRepository result = null;

        switch (type) {
            case "default":
                result = (IVehicleRepository) new VehicleRepository();
                break;
        }
        return result;

    }
}