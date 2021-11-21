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
import co.unicauca.parkinglot.infra.Lottery;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

/**
 * Un cliente main de prueba
 *
 * @author Libardo
 */
public class ClientMain {
    public static void main(String[] args) {
        Vehicle veh = new Vehicle("FTK-123", TypeEnum.MOTO);
        LocalDateTime input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0);
        LocalDateTime output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 19, 30);
        IVehicleRepository repo = RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repo); //Inyección de dependencias
        long result = service.calculateParkingCost(veh, input, output);
        if(veh.getType().equals(TypeEnum.TRUCK)){
            int n=(int)(Math.random()*100+1);
            int l = Lottery.getLottery(n);
            System.out.println("Numero jugado: "+n);
            if(l==0){
                System.out.println("Ganaste el servicio es gratis, ahorraste: "+result);
                result = 0;
            }  
            else {
                System.out.println("Resultado: "+l +" \nVuelve a intentarlo!");
            }
        }
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

