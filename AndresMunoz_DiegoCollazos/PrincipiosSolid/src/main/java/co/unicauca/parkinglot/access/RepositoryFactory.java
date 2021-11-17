package co.unicauca.parkinglot.access;

public class RepositoryFactory {
    public static RepositoryFactory instance;

    RepositoryFactory () {}

    public static RepositoryFactory getInstance() {
        return instance;
    }

    public IVehicleRepository getRepositoryType(String type) {
        IVehicleRepository result = null;

        switch(type) {
            case "default":
                result = new VehicleRepository();
                break;
        }

        return result;
    }
}