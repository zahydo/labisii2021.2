/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parking.negocio;

import java.time.LocalDateTime;

/**
 *
 * @author cerqu
 */
public class CarParkingCost implements IParkingCost{

    @Override
    public long calculatecost(Vehicle veh, LocalDateTime horaEntrada, LocalDateTime horaSalida) {
        
        long costo = 0;
        int diasHoras = calcularHoras(horaEntrada, horaSalida);
        
        if(diasHoras == 0 && horaEntrada.getHour() - horaSalida.getHour() < 1) {
            costo = 2000;
        } else if(diasHoras == 0 && horaEntrada.getHour() - horaSalida.getHour() == 1) {
            costo = 4000;
        } else {
            int numHoras = horaSalida.getHour() - horaEntrada.getHour() + calcularHoras(horaEntrada, horaSalida);
            int numMinutos;
            if (horaSalida.getMinute() < horaEntrada.getMinute()) {
                numHoras -= 1;
                numMinutos = (60 + horaSalida.getMinute()) - horaEntrada.getMinute();
            } else {
                numMinutos = horaSalida.getMinute() - horaEntrada.getMinute();
            }
            costo = numHoras * 2000 + ((numMinutos * 2000)/60) + 4000;
        }
        
        return redondeo(costo);
    }

    @Override
    public int calcularHoras(LocalDateTime horaEntrada, LocalDateTime horaSalida) {
        int diaEntrada = horaEntrada.getDayOfMonth();
        int diaSalida = horaSalida.getDayOfMonth();
        int diaTotal = (diaSalida - diaEntrada) * 24;
        return diaTotal;
    }

    @Override
    public long redondeo(long numero) {
        if (numero % 100!= 0) {
            double number = numero / 100;
            long parteEntera = (long) number;
            double parteDecimal = number - parteEntera;
            numero += parteDecimal * 100;
        }
        return numero;
    }
    
}
