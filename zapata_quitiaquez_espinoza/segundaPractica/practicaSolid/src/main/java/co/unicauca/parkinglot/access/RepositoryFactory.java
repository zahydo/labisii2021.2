package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import java.util.List;

public class RepositoryFactory implements IVehicleRepository{
    private static RepositoryFactory instance;
    private RepositoryFactory(){}
    public static RepositoryFactory getInstance(){
        return instance;
    }
    //TODO: Definir el retorno de la funcion.
    public IVehicleRepository getRepository(String type){
        return this.instance.getRepository(type);
    }
    //TODO: Implementar el metodo
    public boolean save(Vehicle vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //TODO: Implementar el metodo
    public List<Vehicle> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	@Override
	public boolean saveVehicle(Vehicle vehiculo) {
		// TODO Auto-generated method stub
		return false;
	}
}
