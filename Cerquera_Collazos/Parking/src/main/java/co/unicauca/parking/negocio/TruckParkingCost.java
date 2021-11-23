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
public class TruckParkingCost implements IParkingCost{

    @Override
    public long calculatecost(Vehicle veh, LocalDateTime horaEntrada, LocalDateTime horaSalida) {
        long costo = 0;
        int horas = calcularHoras(horaEntrada, horaSalida);
        int horasInicio;
        int horasFinal;
        int dias;
        dias = horaSalida.getDayOfMonth() - horaEntrada.getDayOfMonth();
        if(dias == 0) {
            if(horas <= 12) {
                costo = 10000;
            } else {
                costo = 15000;
            }
        } else if(dias >= 3) {
            dias =-2;
            horasInicio = 24 - horaEntrada.getHour();
            horasFinal = horaSalida.getHour();
            costo = (dias * 15000) + ((horasInicio * 15000)/24) + ((horasFinal * 15000)/24);
        }
        return redondeo(costo);
    }

    @Override
    public int calcularHoras(LocalDateTime horaEntrada, LocalDateTime horaSalida) {
        int horasEntrada = horaEntrada.getHour();
        int horasSalida = horaSalida.getHour();
        int horaTotal = (horasSalida - horasEntrada);
        return horaTotal;
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
