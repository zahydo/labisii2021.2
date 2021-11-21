package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import java.sql.Connection;
import java.util.List;

public class VehicleRepository implements IVehicleRepository{
    private Connection conn;
    
   //TODO: Desarrollar el metodo constructor
    public VehicleRepository(){}
    //TODO: Definir el valor de retorno
    public boolean save(Vehicle newVehicle){
        return false;
    }
    //TODO: Definir el valor de retorno
    public List<Vehicle> list(){
        return null;
    }
    //TODO: Implementar el metodo
    private void initDatabase(){}
    //TODO: Implementar el metodo
    public void connect(){}
    //TODO: Implementar el metodo
    public void disconnect(){}
	@Override
	public boolean saveVehicle(Vehicle vehiculo) {
		// TODO Auto-generated method stub
		return false;
	}
}