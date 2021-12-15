/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.presentation;
import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.access.RepositoryFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.service.Service;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
/**
 * Un cliente main de prueba
 *
 * @author Arturo
 */
public class ClientMain {

    public static void main(String[] args) {
        IVehicleRepository repo = RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repo); //Inyección de dependencias
        
        Vehicle veh = new Vehicle("FTK-123", TypeEnum.MOTO);
        LocalDateTime input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 20, 0);
        LocalDateTime output = LocalDateTime.of(2021, Month.FEBRUARY, 26, 19, 30);
        long result = service.calculateParkingCost(veh, input, output);
        System.out.println("Valor a pagar por el vehículo tipo "+veh.getType()+": " + result);
        service.saveVehicle(veh);
        
        veh = new Vehicle("JNK-124", TypeEnum.CAR);
        input =  LocalDateTime.of(2021, Month.JANUARY, 22, 12, 0);
        output = LocalDateTime.of(2021, Month.JANUARY, 24, 06, 20);
        result = service.calculateParkingCost(veh, input, output);
        System.out.println("Valor a pagar por el vehículo tipo "+veh.getType()+": " + result);
        service.saveVehicle(veh);
        
        veh = new Vehicle("HKP-667", TypeEnum.TRUCK);
        input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0);
        output = LocalDateTime.of(2021, Month.FEBRUARY, 25, 9, 15);
        result = service.calculateParkingCost(veh, input, output);
        System.out.println("Valor a pagar por el vehículo tipo "+veh.getType()+": " + result);
        service.promocion(44);
        service.saveVehicle(veh);
        
        List<Vehicle> list = service.listVehicles();
        service.listVehicles().forEach(v -> {
            System.out.println(v);
        });
    }
}
