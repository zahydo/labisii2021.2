package co.unicauca.parkinglot.domain;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author jnino_jabella
 */
public class MotoParkingCost implements lParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        Duration Duracion = Duration.between(input, output);
        long TotalMinutos = Duracion.toMinutes();
        long TarifaFija = 2000;
        long TarifaFijaFraccion = 1000;
        if (TotalMinutos < 60) {
            return TarifaFijaFraccion;
        }
        return TarifaFija + ValorRedondeado(TotalMinutos, TarifaFijaFraccion);
    }
    
    private long ValorRedondeado(long prmTotalMinutos,long prmTarifaFijaFraccion){
        float MinutosFraccion = prmTotalMinutos - 60;
        float ValorRedondear = prmTarifaFijaFraccion * MinutosFraccion/6000;
        return (long) Math.ceil(ValorRedondear) * 100;
    }

}
