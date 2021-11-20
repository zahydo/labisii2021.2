/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicuaca.parkinglot.presentation;

import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicuaca.parkinglot.access.IVehicleRepository;
import co.unicuaca.parkinglot.access.RepositoryFactory;
import co.unicuaca.parkinglot.domain.service.Service;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

/**
 * @author Daniel Cerón 
 */
public class ClientMain {
     public static void main(String[] args) {
        Vehicle veh = new Vehicle("FTK-123", TypeEnum.MOTO);
        LocalDateTime input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0);
        LocalDateTime output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 19, 30);
        IVehicleRepository repo = RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repo); //Inyección de dependencias
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
