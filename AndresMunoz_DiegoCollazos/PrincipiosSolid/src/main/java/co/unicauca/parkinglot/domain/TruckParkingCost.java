package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

<<<<<<< HEAD
/**
 *
 * @author ASUS
 */
public class TruckParkingCost implements IParkingCost {

    String informacionSorteo = "";
    boolean ganoSorteo = false;

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        Duration d1 = Duration.between(input, output);
        double horas = d1.toMinutes() / 60.00;
        long cost = 0;
        if (ganoSorteo) {
            return 0;
        }
        if (horas <= 12) {
            cost = 10000;
        } else if (12 < horas && horas <= 24) {
            cost = 15000; 
        } else {
            double costo = (horas/24.00) * 15000; 
            cost = (long) Math.ceil(costo / 1000) * 1000;
        }
        return cost;
    }

    public void sorteo(int number) {
        int valor = (int) Math.floor(Math.random() * 1001);
        if (valor < 0 || valor > 1000) {
            informacionSorteo = "número inválido";
            ganoSorteo = false;
        } else if (valor == number) {
            informacionSorteo = "Ganó sorteo";
            ganoSorteo = true;
        } else {
            informacionSorteo = "no ganó sorteo";
            ganoSorteo = false;
        }
    }

    public String getInformacionSorteo() {
        return informacionSorteo;
    }

=======
public class TruckParkingCost implements IParkingCost{
    public TruckParkingCost() {
    }
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        Duration d1 = Duration.between(input, output); 
        double horas = d1.toMinutes()/60; 
        long cost = 0; 
        
        if(horas > 12 && horas <= 24){
            cost = 15000; 
        }else if(horas <= 12){
            cost = 10000; 
        }else {
            double costodias = (horas/24.00)*15000;  
            cost = (long)Math.ceil(costodias/1000)*1000;  
        }
        return cost; 
    }
>>>>>>> 49ae8005f19ac53341d69a99d21d49ab9b65ceca
}
