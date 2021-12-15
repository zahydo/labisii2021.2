/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.parkinglot.infra;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Antonio E
 */
public class Utilities {
    
    public static long round(long valor){
        double aux = valor;
        valor = (long) (Math.ceil(aux/100) * 100);
        return valor;
    }
    
    public static int[] getDif(LocalDateTime input, LocalDateTime output){
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
