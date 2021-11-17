package co.unicauca.domain;

import java.time.Duration;
import java.time.LocalDateTime;

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

        long extra = (long) (rate * DAY_RATE - (rate * DAY_RATE % 100)) + 100;

        cost = (long) (DAY_RATE * days + extra);

        return cost;

    }
}
