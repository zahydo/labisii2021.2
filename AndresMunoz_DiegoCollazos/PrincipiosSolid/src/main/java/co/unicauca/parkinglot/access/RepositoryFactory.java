package co.unicauca.parkinglot.access;
/**
* +--------------------------------------------------------------------------------------+
* | DESCRIPCION: RepositoryFactory 
* | ESTUDIANTE: Andrés david Muñoz Cerón - Diego Collazos Perafan 
* | FECHA: 17/11/2021
* +--------------------------------------------------------------------------------------+
*/
public class RepositoryFactory {
    public static RepositoryFactory instance;

    private RepositoryFactory () {}

    /*Constructor de la clase */
    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }
    
    /*Retorna la instancia del repositorio*/
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