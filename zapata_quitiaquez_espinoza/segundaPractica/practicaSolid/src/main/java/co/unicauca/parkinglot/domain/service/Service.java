package co.unicauca.parkinglot.domain.service;

import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;
import java.util.List;

public class Service implements IVehicleRepository {
	private IVehicleRepository repository;

	// TODO: Metodo autogenerado. Definir su implementacion
	public Service(IVehicleRepository repo) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	public void service() {
	}

	public void calculateParkingCost() {
	}

	public boolean save(Vehicle vehiculo) {
		return this.listVehicles().add(vehiculo);
	}

	public List<Vehicle> list() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	// TODO: Metodo autogenerado. Al parecer hay que modificar el nombre del metodo
	// save en la interfaz IVehicleRepository
	public boolean saveVehicle(Vehicle veh) {
		return save(veh);
	}

	// TODO: Metodo autogenerado. Al parecer hay que modificar el nombre del metodo
	// list en la interfaz IVehicleRepository
	public List<Vehicle> listVehicles() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	// TODO: Metodo autogenerado, posiblemente sobreescribe al metodo sin argumentos
	public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}
}
