package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author jnino_jabella
 */
public class TruckParkingCost implements lParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        Duration Duracion = Duration.between(input, output);
        
        if (Duracion.toHours() < 12) {
            return 10000;
        } else if (Duracion.toHours() < 24) {
            return 15000;
        } 
        long CantidadDias = Duracion.toDays();
        long CantidadHoras = Duracion.minus(Duration.ofDays(CantidadDias)).toHours();
        return (15000 * CantidadDias) + ValorRedondeado(CantidadHoras, 15000);
    }
    
   private long ValorRedondeado(long prmTotalHoras,long prmTarifaFijaFraccion){
        Double ValorRedondear = (prmTotalHoras * prmTarifaFijaFraccion) / 2400.0;
        return (long) Math.ceil(ValorRedondear) * 100;
    }
}
