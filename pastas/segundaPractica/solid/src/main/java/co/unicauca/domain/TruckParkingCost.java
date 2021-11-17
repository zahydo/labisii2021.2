package co.unicauca.domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class TruckParkingCost implements IParkingCost {

    /*
     * Los camiones pagan un valor de $15.000 por un día completo (de 24 horas). Si
     * el camión está menos o igual de 12 horas se le cobra un valor de $10.000,
     * entre 12 y 24 horas paga $15.000. En adelante de las 24 horas, pagará $15.000
     * por cada día y por las horas restantes se le cobra la fracción de tiempo
     * respecto a los $15.000 (regla de tres simple). Por ejemplo, si estuvo tres
     * días completos y 1 hora, pagaría: 15000x3 + 625 = 45625 = $45.700 (por el
     * redondeo). Específicamente para los camioneros, los cuales son el mercado
     * objetivo, se hace todas las veces un sorteo (Por ejemplo, acertarle a un
     * número aleatorio de entre 1 y 1000), en caso de salir beneficiado, el costo
     * sería 0. Queda a la imaginación proponer los detalles del sorteo.
     */
    static final long DAY_RATE = 15000;
    static final long MIN_RATE = 10000;

    public TruckParkingCost() {
    };

    
    /** 
     * @param veh
     * @param input
     * @param output
     * @return long
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {

        long days = 0, cost = 0;

        Duration duration = Duration.between(input, output);
        double rate;

        if (duration.toHours() <= 12) {
            return MIN_RATE;
        }

        if (duration.toHours() > 12 && duration.toHours() < 24) {
            return DAY_RATE;
        }

        days = duration.toDays();
        long extraHours = ((duration.toHours() % 24));

        rate = (double) extraHours / 24;

        long extra = (long) (rate * DAY_RATE);

        if(extra % 100 != 0){
            extra = extra - (extra%100) + 100;
        }

        cost = (long) (DAY_RATE * days + extra);

        if(lottery()){
            return 0;
        }
        
        return cost;
       

    }

    /**
     * takes two pseudo-random generated number, compares each other and if 
     * they match it returns a bool indicating wether 
     * the discount is applied or not
     * 
     * @return boolean
     */
    public boolean lottery(){
        Random ran1 = new Random();
        Random ran2 = new Random();

        if(ran1.nextInt(1000) == ran2.nextInt(1000)){
            return true;
        }

        return false;
    }
}
