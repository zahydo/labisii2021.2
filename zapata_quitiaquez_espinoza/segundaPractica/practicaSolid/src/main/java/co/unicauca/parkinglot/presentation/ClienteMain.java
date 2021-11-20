package co.unicauca.parkinglot.presentation;

import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.access.RepositoryFactory;
import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.service.Service;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import static java.time.temporal.ChronoUnit.DAYS;

import java.time.Duration;

public class ClienteMain {

	public static void main(String[] args) {
		Vehicle veh = new Vehicle("FTK-123", TypeEnum.MOTO);
		LocalDateTime input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0);
		LocalDateTime output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 19, 30);
		IVehicleRepository repo = RepositoryFactory.getInstance().getRepository("default");
		Service service = new Service(repo); // Inyecci�n de dependencias
		long result = service.calculateParkingCost(veh, input, output);
		System.out.println("Valor a pagar por la moto: " + result);
		service.saveVehicle(veh);
		veh = new Vehicle("JNK-124", TypeEnum.CAR);
		service.saveVehicle(veh);
		List<Vehicle> list = service.listVehicles();
		list.forEach(vehicle -> {
			System.out.println(vehicle.toString());
		});
	}

}
