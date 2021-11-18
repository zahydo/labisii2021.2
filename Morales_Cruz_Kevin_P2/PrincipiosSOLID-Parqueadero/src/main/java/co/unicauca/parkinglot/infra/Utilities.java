/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.infra;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Kevin Daryany Morales
 */
public class Utilities {
    /**
     * Redondea valor coste
     * @param valor
     * @return coste
     */
    public static long redondeo(long valor){
        if (valor%100!=0) {
            long aux1 = valor%1000 - valor%100;
            aux1 += 100;
            valor -= valor%1000;
            valor += aux1;
        }
        return valor;
    }
    /**
     *  Calcula el valor a devolver
     * @param entrada_hora
     * @param salida_hora
     * @return devuelta_coste
     */
    public static int[] gerDiferencia(LocalDateTime input, LocalDateTime output){
        int dias=0;
        int horas=0;
        int minutos=0;
        int [] vDiferencia = new int[3];
        Date fechaInicial = new Date(input.getYear(), input.getMonthValue(), input.getDayOfMonth(), input.getHour(), input.getMinute());
        Date fechaFinal = new Date(output.getYear(), output.getMonthValue(), output.getDayOfMonth(), output.getHour(), output.getMinute());
        
        int diferencia = (int)((fechaFinal.getTime()-fechaInicial.getTime())/1000);
        
        if (diferencia >= 86400) {
            dias = (int) Math.floor(diferencia / 86400);
            diferencia = diferencia - (dias * 86400);
        }
        if (diferencia >= 3600) {
            horas = (int) Math.floor(diferencia / 3600);
            diferencia = diferencia - (horas * 3600);
        }
        if (diferencia >= 60) {
            minutos = (int) Math.floor(diferencia / 60);
        }
        
        vDiferencia[0] = dias;
        vDiferencia[1] = horas;
        vDiferencia[2] = minutos;
        
        return vDiferencia;
    }
}
