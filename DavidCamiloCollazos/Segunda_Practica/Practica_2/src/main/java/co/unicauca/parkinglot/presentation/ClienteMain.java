package co.unicauca.parkinglot.presentation;

import static java.lang.Math.ceil;

import co.unicauca.parkinglot.acces.IVehicleRepository;
import co.unicauca.parkinglot.acces.RepositoryFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.service.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;


/**
 *
 * @author David E dacoes@unicauca.edu.co
 */
public class ClienteMain 
{
    public static void main( String[] args )
    {
        //crea un nuevo vehiculo
        Vehicle veh = new Vehicle("FTK-123", TypeEnum.MOTO);
        //crea una variable de localDatetime que guarda la fecha y hora
        LocalDateTime input = LocalDateTime.of(2021,Month.FEBRUARY,22,8,0);
        LocalDateTime output = LocalDateTime.of(2021, Month.FEBRUARY,22,19,30);
        
        IVehicleRepository repo = RepositoryFactory.getInstance().getRepository("default");
        
        Service service = new Service(repo);//inyección de dependencias
        
        long result = service.calculateParkingCost(veh,input,output);
        System.out.println("Valor a pagar por la moto: " + result);
        service.saveVehicle(veh);
        veh = new Vehicle("JNK-124",TypeEnum.CAR);
        service.saveVehicle(veh);
        ArrayList<Vehicle> list = service.listVehicles();

        
        for(Vehicle vehicle: list){
            System.out.print(vehicle.toString());
        }
        
        /*
        list.forEach(vehicle -> {
        System.out.println(vehicle.toString());
        });
        }*/
     
        

    }
}
