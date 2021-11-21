package co.unicauca.parkinglot.access;

/**
 * @author angiecgomez
 * @author mafemartinez
 */
public class RepositoryFactory {
    
    /**
     * Attributes
     */
    
    private static RepositoryFactory instance;
    
    
    /**
     * Constructor 
     */
    private RepositoryFactory (){   
    }
    
    /**
     * Getters and setters
     */

    /**
     * Gets the only instance of the class
     * @return instance
     */
    public static RepositoryFactory getInstance() {
        if(instance == null){
            instance = new RepositoryFactory();
        }
        return instance;
    }
    
    /**
     * Methods
     */
    
    /**
     * Create an instance of VehicleRepository
     * @param type
     * @return result, this is an instance of the child class of IVehicleRepository
     */
     
    public IVehicleRepository getRepository(String type){
        
        IVehicleRepository result = null;
        
        switch (type){
            case "default":
                result = new VehicleRepository();
                break;
        }
        return result;
    }
    

    
}
