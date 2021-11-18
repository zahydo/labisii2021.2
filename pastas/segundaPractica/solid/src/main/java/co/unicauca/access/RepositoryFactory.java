package co.unicauca.access;

public class RepositoryFactory {
    
    private static RepositoryFactory instance;

    private RepositoryFactory(){}
    
    /** 
     * @return RepositoryFactory
     */
    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }

        return instance;
    }

    /** 
     * @param type
     * @return IVehicleRepository
     */
    public IVehicleRepository getRepository(String type){
        IVehicleRepository result = null;

        switch (type) {
            case "default":
                result = new VehicleRepository();
                break;
        }
        return result;
    }
}
