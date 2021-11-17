package co.unicauca.parkinglot.access;

public class RepositoryFactory {
    public static RepositoryFactory instance;

    private RepositoryFactory () {}

    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
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