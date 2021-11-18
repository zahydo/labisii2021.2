package co.unicauca.parkinglot.domain;
/**
* +--------------------------------------------------------------------------------------+
* | DESCRIPCION: TruckParkingCost - Calcula la tarifa de parqueo total de un camion.
* | ESTUDIANTE: Andrés david Muñoz Cerón - Diego Collazos Perafan 
* | FECHA: 17/11/2021
* +--------------------------------------------------------------------------------------+
*/

/*librerias TIME*/
import java.time.Duration;
import java.time.LocalDateTime;

/*Class*/
public class TruckParkingCost implements IParkingCost {
    
    /*Variables de información*/
    private String informacionSorteo = ""; 
    private boolean ganoSorteo = false;

    /*función que calcula y retorna la tarifa de parqueo*/
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        Duration d1 = Duration.between(input, output); //timestamp
        double horas = d1.toMinutes() / 60.00; //horas parte entera, minutos parte decimal
        long cost = 0;
        if (ganoSorteo) {
            return 0;
        }
        if (horas <= 12) {
            cost = 10000;
        } else if (12 < horas && horas <= 24) {
            cost = 15000; 
        } else {
            //Calculos de costo según reglas del enunciado
            double costo = (d1.toDays()) * 15000; 
            costo += Math.abs(input.getHour() - output.getHour())/24.00 * 15000; 
            cost = (long) Math.ceil(costo / 100) * 100;  
            
        }
        return cost;
    }

    /*Método que simula un sorteo*/
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

}
