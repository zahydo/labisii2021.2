package co.unicauca.parkinglot.access;
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