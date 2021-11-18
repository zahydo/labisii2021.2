
package co.unicauca.parkinglot.access;

/**
 *
 * @author Dz
 */
public class RepositoryFactory {

    private static RepositoryFactory instance;
    private IVehicleRepository repository;
    
    private RepositoryFactory() {
        this.repository = new VehicleRepository();
    }

    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }

    
    public IVehicleRepository getRepository(String type) {
        
         return this.repository;
    }

    



}
